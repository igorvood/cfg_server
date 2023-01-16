package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.controller.intf.PumlGeneratorController
import ru.vtb.configuration.server.rest.intf.PumlGeneratorRest

@RestController
class PumlGeneratorRestImpl(
    val pumlGeneratorController: PumlGeneratorController
) : PumlGeneratorRest {
    //    @ApiResponses(
//        value = [ApiResponse(
//            responseCode = "200",
//            description = "Формирует puml файл по всему графу",
//            content = [Content(
//                mediaType = "application/json",
//                array = ArraySchema(
//                    schema = Schema(
//                        implementation = String::class
//                    )
//                )
//            )]
//        )]
//    )
    @Operation(summary = "Формирует puml файл по всему графу", tags = ["plantUML"])
    @GetMapping("/pumlFileByGraph")
    override fun plantUMLNew(graphId: String): String {
        return pumlGeneratorController.generatePumlByGraphId(graphId)
    }

}