package ru.vtb.jpaprocessor.processor.abstraction

import ru.vtb.jpaprocessor.generator.model.AbstractGeneratedClass
import java.io.OutputStreamWriter
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

abstract class AbstractGenerationProcessor<GeneratedClass : AbstractGeneratedClass<*>> : AbstractProcessor() {
    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    protected fun log(kind: Diagnostic.Kind, msg: CharSequence?) {
        processingEnv.messager.printMessage(kind, "${this.javaClass.canonicalName}: $msg")
    }

    abstract fun generatedClassInfo(typeElement: TypeElement): GeneratedClass

    abstract fun textGenerator(generatedClassData: GeneratedClass): String

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val flatMap = annotations
            .flatMap { annotation -> roundEnv.getElementsAnnotatedWith(annotation) }
        val filterIsInstance = flatMap
            .filterIsInstance<TypeElement>()
        filterIsInstance
            .map { generateBy ->
                val generatedClass = generatedClassInfo(generateBy)
                val out = processingEnv.filer
                    .createSourceFile(generatedClass.fullGeneratedName())
                    .let { OutputStreamWriter(it.openOutputStream()) }

                log(
                    Diagnostic.Kind.MANDATORY_WARNING,
                    "Generate class ${generatedClass.generatedClassName()} by class ${generatedClass.annotatedClass.name()}"
                )

                out.write(textGenerator(generatedClass))
                out.close()
            }
        return true
    }

}