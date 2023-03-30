package ru.vtb.jpaprocessor.processor.abstraction

import ru.vtb.jpaprocessor.generator.model.GeneratedJpaRepositoryClass
import ru.vtb.jpaprocessor.generator.model.IAnnotatedClass
import ru.vtb.jpaprocessor.generator.model.IGeneratedClass
import java.io.OutputStreamWriter
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

abstract class AbstractGenerationProcessor<ANNO, out AnnotatedClass: IAnnotatedClass, out GeneratedClass: IGeneratedClass>: AbstractProcessor() {

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }

    fun generateText1(GeneratedClass: IGeneratedClass): String{
        TODO()
    }

    fun process1(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val flatMap1 = annotations
            .flatMap { orIsNullAnnotation -> roundEnv.getElementsAnnotatedWith(orIsNullAnnotation) }
            .filterIsInstance<TypeElement>()
            .firstOrNull()?.let { generateBy ->
                val annotatedClass = ru.vtb.jpaprocessor.generator.model.AnnotatedClass(generateBy)
                val generatedJpaRepositoryClass = GeneratedJpaRepositoryClass(annotatedClass)

                val out = processingEnv.filer
                    .createSourceFile(generatedJpaRepositoryClass.fullGeneratedName())
                    .let { OutputStreamWriter(it.openOutputStream()) }



                out.write(generateText1(generatedJpaRepositoryClass))
                out.close()
            }


        TODO()

    }

}