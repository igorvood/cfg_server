package ru.vtb.configuration.server.ui

import io.swagger.v3.oas.annotations.Operation
import net.sourceforge.plantuml.FileFormat
import net.sourceforge.plantuml.FileFormatOption
import net.sourceforge.plantuml.SourceStringReader
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.controller.intf.PumlGeneratorController
import ru.vtb.configuration.server.rest.intf.PumlGeneratorRest
import ru.vtb.configuration.server.ui.controler.TableMetaController
import ru.vtb.configuration.server.ui.dto.SvgDto
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset


@RestController
@CrossOrigin
class UiRestPuml(private val uiController: UiController,
                 private val tableMetaController: TableMetaController,
                 private val pumlGeneratorController: PumlGeneratorController

) {
    @Value("classpath:tmp.puml")
    lateinit var resourceFile: Resource

    @Operation(summary = "puml", tags = ["UI"])
    @GetMapping("/pumlSVG")
    fun puml(): SvgDto {
        val generatePumlByGraphId = pumlGeneratorController.generatePumlByGraphId("rto_graph")
        val os  = ByteArrayOutputStream()
        val reader = SourceStringReader(generatePumlByGraphId);
        val generateImage = reader.generateImage(os, FileFormatOption(FileFormat.SVG))
        os.close()
        val svgData = String(os.toByteArray(), Charset.forName("UTF-8"))
        return SvgDto(svgData)



//        val readText = resourceFile.file.readText()
//        val os  = ByteArrayOutputStream()
//        val reader = SourceStringReader(source);
//        val generateImage = reader.generateImage(os, FileFormatOption(FileFormat.SVG))
//        os.close()
//        val svgData = String(os.toByteArray(), Charset.forName("UTF-8"))
//        return SvgDto(svgData)
    }



    companion object{

        val source = """@startuml
Bob -> Alice : hello
@enduml"""
    }

}