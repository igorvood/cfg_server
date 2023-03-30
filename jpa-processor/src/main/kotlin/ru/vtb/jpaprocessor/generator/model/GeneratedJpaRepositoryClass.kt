package ru.vtb.jpaprocessor.generator.model

class GeneratedJpaRepositoryClass(annotatedClass: AnnotatedClass) : AbstractGeneratedClass(annotatedClass) {
    override fun generatedClassName(): String = annotatedClass.shortName() + "GeneratedRepository"

    override fun generatedPackageName(): String = "${annotatedClass.packageName()}.generated"

}
