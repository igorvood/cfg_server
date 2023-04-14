package ru.vtb.processor.abstraction.model.abstraction

import java.util.*
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element

inline fun <reified ANNO: Annotation, TYPE_VAL> Element.proxyAnnotationValue(processingEnv: ProcessingEnvironment, valueName: String): Optional<TYPE_VAL> {
    val map = this.annotation<ANNO>()
        .map { idAnnoTat ->
            val annotationValue = this.annotationValue<ANNO>(processingEnv, valueName)
            return@map annotationValue as TYPE_VAL
        }
    return map
}