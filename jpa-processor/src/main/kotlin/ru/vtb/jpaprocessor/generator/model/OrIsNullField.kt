package ru.vtb.jpaprocessor.generator.model

import java.util.*
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element

interface OrIsNullField {

    val element: Element
    fun name(): String
    fun type(): String
    fun betterClass(): AbstractAnnotatedClass?
}

inline fun <reified ANNO : Annotation> OrIsNullField.annotation(processingEnv: ProcessingEnvironment): Optional<ANNO> =
    element.annotation(processingEnv)


inline fun <reified ANNO : Annotation> Element.annotation(processingEnv: ProcessingEnvironment): Optional<ANNO> {
//    val actionType = processingEnv.getElementUtils().getTypeElement(ANNO::class.java.name).asType()
//    val filter = this.annotationMirrors
//        .filter { it.annotationType.equals(actionType) }
//        .flatMap { it.elementValues.entries  }
//    val first = filter.first().value.value
//    val element = this
    val annotation = this.getAnnotation(ANNO::class.java)
    return Optional.ofNullable(annotation)
}

inline fun <reified ANNO : Annotation> Element.annotationValue(
    processingEnv: ProcessingEnvironment,
    valueName: String
): Any {
    val actionType = processingEnv.getElementUtils().getTypeElement(ANNO::class.java.name).asType()
    val filter = this.annotationMirrors
        .filter { it.annotationType.equals(actionType) }
        .flatMap { it.elementValues.entries }
    return filter
        .filter { it.key.simpleName.toString() == valueName }
        .map { it.value.value }
        .first()


}
