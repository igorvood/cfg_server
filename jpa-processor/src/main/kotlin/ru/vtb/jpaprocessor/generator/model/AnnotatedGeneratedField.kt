package ru.vtb.jpaprocessor.generator.model

import ru.vtb.processor.abstraction.model.AbstractAnnotatedClass
import ru.vtb.processor.abstraction.model.IGeneratedField
import javax.lang.model.element.Element

class AnnotatedGeneratedField(override val element: Element) : IGeneratedField {
    override fun name(): String {
        return element.simpleName.toString()
    }

    override fun type(): String {
        return element.asType().toString()
    }

    //    override fun annotation(): MutableList<out AnnotationMirror> {
//        element.getAnnotation()
//
//        val annotationMirrors = element.annotationMirrors
//        val first = annotationMirrors.first().annotationType.asElement().asType().javaClass
//        return Optional.ofNullable(annotationMirrors).orElse(mutableListOf())
//    }
    override fun betterClass(): AbstractAnnotatedClass? {
        return if (element.asType().kind.isPrimitive) {
            null
        } else AnnotatedEntityClass(element)
    }

    val klassType: AbstractAnnotatedClass?
        get() = betterClass()
}