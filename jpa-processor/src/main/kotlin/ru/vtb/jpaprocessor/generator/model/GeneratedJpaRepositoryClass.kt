package ru.vtb.jpaprocessor.generator.model

 class GeneratedJpaRepositoryClass(annotatedClass: AnnotatedClass) : IGeneratedClass(annotatedClass){
    override fun generatedClassName(): String = annotatedClass.shortName()+"GeneratedRepository"

    override fun generatedPackageName(): String ="${annotatedClass.packageName()}.generated"

}
