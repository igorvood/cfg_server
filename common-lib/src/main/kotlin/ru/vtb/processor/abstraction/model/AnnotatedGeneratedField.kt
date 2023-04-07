package ru.vtb.processor.abstraction.model

import ru.vtb.processor.abstraction.model.abstraction.AbstractAnnotatedClass
import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField
import javax.lang.model.element.Element

class AnnotatedGeneratedField(override val element: Element) : IGeneratedField {
    override fun name(): String {
        return element.simpleName.toString()
    }

    override fun type(): String {
        return element.asType().toString()
    }
    override fun betterClass(): AbstractAnnotatedClass? {
        return if (element.asType().kind.isPrimitive) {
            null
        } else AnnotatedEntityClass(element)
    }

    val klassType: AbstractAnnotatedClass?
        get() = betterClass()
}