package ru.vtb.jpaprocessor.generator.model

data class GeneratedJpaRepositoryClass(val annotatedClass: AnnotatedClass) : GeneratedClass{
    override fun generatedClassName(): String = annotatedClass.shortName()+"GeneratedRepository"

    override fun generatedPackageName(): String ="${annotatedClass.packageName()}.generated"

}
