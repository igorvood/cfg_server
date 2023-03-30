package ru.vtb.jpaprocessor.generator.model

import javax.lang.model.element.Element

abstract class IAnnotatedClass(val element: Element)/*<Annotation>*/ {
    abstract fun name(): String

    abstract fun fields(): List<OrIsNullField>

    fun shortName(): String {
        val dotIdx = name().lastIndexOf('.')
        return name().substring(dotIdx + 1)
    }

    fun packageName(): String {
        val dotIdx = name().lastIndexOf('.')
        return name().substring(0, dotIdx)
    }


}