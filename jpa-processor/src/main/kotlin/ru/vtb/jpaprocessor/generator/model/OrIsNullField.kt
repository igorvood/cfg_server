package ru.vtb.jpaprocessor.generator.model

import java.util.Optional
import javax.lang.model.element.Element

interface OrIsNullField {

    val element: Element
    fun name(): String
    fun type(): String
    fun betterClass(): AbstractAnnotatedClass?
}

inline fun <reified ANNO : Annotation> OrIsNullField.annotation(): Optional<ANNO>  =
     Optional.ofNullable(element.getAnnotation(ANNO::class.java))


