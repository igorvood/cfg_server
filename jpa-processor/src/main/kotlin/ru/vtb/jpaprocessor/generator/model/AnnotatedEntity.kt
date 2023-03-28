package ru.vtb.jpaprocessor.generator.model

import javax.lang.model.element.Element
import javax.lang.model.type.ExecutableType

class AnnotatedEntity(private val queryMethod: Element) : OrIsNullClass {
    override fun name(): String {
        val method = queryMethod.asType() as ExecutableType
        val returnTypeName = method.returnType.toString()
        return returnTypeName.replace("^.*<(.*)>".toRegex(), "$1")
    }

    override fun fields(): List<OrIsNullField> {
        return emptyList()
    }
}