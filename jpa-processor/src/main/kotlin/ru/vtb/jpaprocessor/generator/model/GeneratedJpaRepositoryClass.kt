package ru.vtb.jpaprocessor.generator.model

data class GeneratedJpaRepositoryClass(val annotatedClass: AnnotatedClass) {

    val generatedClassName =annotatedClass.shortName()+"GeneratedRepository"

    val generatedPackageName = "${annotatedClass.packageName()}.generated"

    val fullGeneratedName = "$generatedPackageName.$generatedClassName"

}
