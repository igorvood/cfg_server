package ru.vtb.processor.abstraction.model

import ru.vtb.processor.abstraction.model.abstraction.AbstractAnnotatedClass
import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField
import ru.vtb.processor.abstraction.model.abstraction.annotation
import ru.vtb.processor.abstraction.model.abstraction.annotationValue
import java.lang.instrument.IllegalClassFormatException
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.persistence.Id
import javax.persistence.IdClass

class AnnotatedEntityClass(element: Element) : AbstractAnnotatedClass(element) {
    override fun name(): String {
        return element.asType().toString()
    }

    override fun fields(): List<IGeneratedField> {
        return element.enclosedElements
            .filter { e: Element -> e.kind.isField }
            .map { element: Element -> AnnotatedGeneratedField(element) }

    }

    fun calculateIdClass(processingEnv: ProcessingEnvironment): Result<String> =
        kotlin.runCatching {
            element.annotation<IdClass>()
                .map { idAnnoTat ->
                    val annotationValue = element.annotationValue<IdClass>(processingEnv, "value")
                    annotationValue.toString()
                }
                .orElseGet {
                    val withIdFileds = fields()
                        .map { f ->
                            f to f.annotation<Id>()
                        }
                        .filter { it.second.isPresent }
                        .map { it.first }

                    if (withIdFileds.size == 1) {
                        withIdFileds.first().type()
                    } else throw IllegalClassFormatException("Unable to find identifier for class ${name()} . Entity must be annotated IdClass or have only one field annotated Id")
                }
        }

}