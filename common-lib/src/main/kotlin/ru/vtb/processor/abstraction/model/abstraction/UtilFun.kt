package ru.vtb.processor.abstraction.model.abstraction

import java.util.*
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element

inline fun <reified ANNO : Annotation, reified TYPE_VAL> Element.proxyAnnotationValue(
    processingEnv: ProcessingEnvironment,
    valueName: String
): Optional<TYPE_VAL> {
    val map = this.annotation<ANNO>()
        .map { idAnnoTat ->
            val annotationValue = this.annotationValue<ANNO>(processingEnv, valueName)
            return@map annotationValue as TYPE_VAL
        }
    return map
}

fun String.mapKotlinType(): String =
    if (this == "java.lang.String") "String"
//    else if (this == "java.math.BigInteger") "Int"
    else if (this == "java.lang.Integer") "Int"
    else if (this == "boolean") "Boolean"
    else if (this == "int") "Int"

    else this
