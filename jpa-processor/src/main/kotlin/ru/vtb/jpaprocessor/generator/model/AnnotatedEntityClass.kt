package ru.vtb.jpaprocessor.generator.model

import ru.vtb.processor.abstraction.model.AbstractAnnotatedClass
import ru.vtb.processor.abstraction.model.OrIsNullField
import ru.vtb.processor.abstraction.model.annotation
import ru.vtb.processor.abstraction.model.annotationValue
import java.lang.instrument.IllegalClassFormatException
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element
import javax.persistence.Id
import javax.persistence.IdClass

class AnnotatedEntityClass(element: Element) : AbstractAnnotatedClass(element) {
    override fun name(): String {
        return element.asType().toString()
    }

    override fun fields(): List<OrIsNullField> {
        return element.enclosedElements
            .filter { e: Element -> e.kind.isField }
            .map { element: Element -> AnnotatedOrIsNullField(element) }

    }

    fun calculateIdClass(processingEnv: ProcessingEnvironment): Result<String> =
        kotlin.runCatching {
            element.annotation<IdClass>(processingEnv)
                .map { idAnnoTat ->
//                    val annotationValue = element.annotationValue<IdClass>(processingEnv, "value")
//                    val value = idAnnoTat.value
//                    val java = value.java
//                    val canonicalName = java.canonicalName
//                    canonicalName
                    element.annotationValue<IdClass>(processingEnv, "value").toString()
                }
                .orElseGet {
                    val withIdFileds = fields()
                        .map { f ->
                            f to f.annotation<Id>(processingEnv)
                        }
                        .filter { it.second.isPresent }
                        .map { it.first }

                    if (withIdFileds.size == 1) {
                        withIdFileds.first().type()
                    } else throw IllegalClassFormatException("Unable to find identifier for class ${name()} . Entity must be annotated IdClass or have only one field annotated Id")
                }
        }

//    fun calculateIdClass():String{
//
//        val map = Optional.ofNullable(element.getAnnotation(IdClass::class.java))
//            .map { it.value.java.canonicalName }
//            .orElseGet {
//                val fields = fields()
//                val annotated = fields
//                    .filter {field ->
//                        val annotation = field.annotation()
//                        val idOnly = annotation
//                            .map { ann -> ann.annotationType }
//                            .filter { p ->
//                                val annotation1 = p.getAnnotationsByType(Id::class.java)
//                                annotation1.isNotEmpty()
//                            }
//                        idOnly.size == 1
//
//                    }
//
//                val s = if (annotated.size == 1) {
//                    annotated.first().type()
//                } else throw IllegalClassFormatException("Unable to find identifyer class. Entity must be annotated IdClass or have only one field annotated Id")
//                s
//
//            }
//
//        return map
//    }


}