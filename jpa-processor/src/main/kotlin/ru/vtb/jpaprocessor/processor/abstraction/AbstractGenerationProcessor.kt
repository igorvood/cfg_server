package ru.vtb.jpaprocessor.processor.abstraction

import ru.vtb.jpaprocessor.generator.model.IAnnotatedClass
import ru.vtb.jpaprocessor.generator.model.IGeneratedClass
import java.io.OutputStreamWriter
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

abstract class AbstractGenerationProcessor<ANNO, out AnnotatedClass : IAnnotatedClass, GeneratedClass : IGeneratedClass> :
    AbstractProcessor() {

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    abstract fun generatedClass(typeElement: TypeElement): GeneratedClass

    abstract fun generateText1(GeneratedClass: GeneratedClass): String

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        annotations
            .flatMap { orIsNullAnnotation -> roundEnv.getElementsAnnotatedWith(orIsNullAnnotation) }
            .filterIsInstance<TypeElement>()
            .firstOrNull()?.let { generateBy ->
                val generatedClass = generatedClass(generateBy)
                val out = processingEnv.filer
                    .createSourceFile(generatedClass.fullGeneratedName())
                    .let { OutputStreamWriter(it.openOutputStream()) }

                processingEnv.messager.printMessage(
                    Diagnostic.Kind.MANDATORY_WARNING,
                    "Generate class ${generatedClass.generatedClassName()} by class ${generatedClass.annotatedClass.name()}"
                )

                out.write(generateText1(generatedClass))
                out.close()
            }
        return true
    }

}