package ru.vtb.jpaprocessor.generator.model

import java.util.stream.Collectors
import javax.lang.model.element.Element

class AnnotatedClass(element: Element) : IAnnotatedClass(element) {
    override fun name(): String {
        return element.asType().toString()
    }

    override fun fields(): List<OrIsNullField> {
        return element.enclosedElements.stream()
            .filter { e: Element -> e.kind.isField }
            .map { element: Element -> AnnotatedOrIsNullField(element) }
            .collect(Collectors.toList())
    }


}