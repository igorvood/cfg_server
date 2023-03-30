package ru.vtb.jpaprocessor.generator.model

import ru.vtb.jpaprocessor.annotation.OrIsNullQuery
import javax.lang.model.element.Element
import javax.lang.model.type.ExecutableType
import javax.lang.model.util.Types

class AnnotatedOrIsNullSearchMethod(private val queryMethod: Element, private val typeUtils: Types) :
    OrIsNullSearchMethod {
    override fun name(): String {
        return queryMethod.simpleName.toString()
    }

    override fun entity(): IAnnotatedClass {
        return AnnotatedEntity(queryMethod)
    }

    override fun filter(): IAnnotatedClass {
        val queryMethod = queryMethod.asType() as ExecutableType
        val queryMethodParameter = queryMethod.parameterTypes.iterator().next()
        return AnnotatedClass(typeUtils.asElement(queryMethodParameter))
    }

    override fun query(): String {
        return queryMethod.getAnnotation(OrIsNullQuery::class.java).value
    }
}