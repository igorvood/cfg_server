package ru.vtb.jpaprocessor.processor.abstraction

import ru.vtb.jpaprocessor.generator.model.IAnnotatedClass
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement

abstract class AbstractGenerationProcessor<ANNO, out AnnotatedClass: IAnnotatedClass>: AbstractProcessor() {

    @Synchronized
    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
    }


    fun process1(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val flatMap1 = annotations
            .flatMap { orIsNullAnnotation -> roundEnv.getElementsAnnotatedWith(orIsNullAnnotation) }
            .filterIsInstance<TypeElement>()

        TODO()

    }

}