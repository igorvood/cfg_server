package ru.vtb.jpaprocessor.generator.template

import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateException
import freemarker.template.TemplateExceptionHandler
import ru.vtb.jpaprocessor.generator.model.IAnnotatedClass
import ru.vtb.jpaprocessor.generator.model.OrIsNullSearchMethod
import java.io.IOException
import java.io.OutputStreamWriter
import java.io.Writer
import java.util.stream.Collectors
import javax.annotation.processing.Filer

class TemplateSearchServiceGenerator(
    private val orIsNullSearchInterface: IAnnotatedClass, private val methods: List<OrIsNullSearchMethod>
) {
    private var temp: Template? = null

    init {
        val cfg = Configuration(Configuration.VERSION_2_3_23)
        try {
            cfg.setClassForTemplateLoading(this.javaClass, "/")
            cfg.defaultEncoding = "UTF-8"
            cfg.templateExceptionHandler = TemplateExceptionHandler.RETHROW_HANDLER
            cfg.logTemplateExceptions = false
            temp = cfg.getTemplate("service.ftpl")
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    fun toFiler(filer: Filer) {
        val root: MutableMap<String, Any> = HashMap()
        root["packageName"] = orIsNullSearchInterface.packageName()
        root["klass"] = FreeKlass(orIsNullSearchInterface)
        root["methods"] = methods.stream().map { method: OrIsNullSearchMethod? -> FreeMethod(method) }
                .collect(Collectors.toList())
        try {
            val sourceFile = filer.createSourceFile(orIsNullSearchInterface.name() + "Impl")
            val out: Writer = OutputStreamWriter(sourceFile.openOutputStream())
            temp!!.process(root, out)
            out.close()
        } catch (e: TemplateException) {
            throw RuntimeException(e)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}