package ru.vtb.jpaprocessor.generator.model

class GeneratedJpaRepositoryClass(annotatedEntityClass: AnnotatedEntityClass) :
    AbstractGeneratedClass<AnnotatedEntityClass>(annotatedEntityClass) {
    override fun generatedClassName(): String = annotatedClass.shortName() + "GeneratedRepository"

    override fun generatedPackageName(): String = "${annotatedClass.packageName()}.generated"

}
