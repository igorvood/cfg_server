package ru.vood.processor.abstraction.model

import ru.vood.processor.abstraction.model.abstraction.AbstractGeneratedClass

class GeneratedJpaRepositoryClass(annotatedEntityClass: AnnotatedEntityClass) :
    AbstractGeneratedClass<AnnotatedEntityClass>(annotatedEntityClass) {
    override fun generatedClassName(): String = annotatedClass.shortName() + "GeneratedRepository"

    override fun generatedPackageName(): String = "${annotatedClass.packageName()}.generated"

}
