package ru.vtb.jpaprocessor.generator.model

import javax.lang.model.element.Element

class AnnotatedOrIsNullField(private val element: Element) : OrIsNullField {
    override fun name(): String {
        return element.simpleName.toString()
    }

    override fun type(): String {
        return element.asType().toString()
    }

    override fun betterClass(): OrIsNullClass? {
        return if (element.asType().kind.isPrimitive) {
            null
        } else AnnotatedOrIsNullClass(element)
    }

    val klassType: OrIsNullClass?
        get() = betterClass()
}