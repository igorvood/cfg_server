package ru.vtb.processor.abstraction.model

import ru.vtb.processor.abstraction.model.abstraction.AbstractAnnotatedClass
import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField
import ru.vtb.processor.abstraction.model.abstraction.annotation
import javax.lang.model.element.Element
import javax.persistence.Column

class AnnotatedGeneratedField(override val element: Element) : IGeneratedField {
    override fun name(): String {
        return element.simpleName.toString()
    }

    override fun isNullable(): Boolean {

        val annotation1 = element.annotation<Column>()
        val annotation = annotation1
            .map { it.nullable }
            .orElseGet { true }
        return annotation
    }

    override fun isUpdateble(): Boolean {

        val annotation1 = element.annotation<Column>()
        val annotation = annotation1
            .map { it.updatable }
            .orElseGet { true }
        return annotation
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