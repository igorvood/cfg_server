package ru.vtb.jpaprocessor.generator.model

abstract class AbstractGeneratedClass(val annotatedClass: AbstractAnnotatedClass) {

    abstract fun generatedClassName(): String

    abstract fun generatedPackageName(): String

    fun fullGeneratedName(): String = "${generatedPackageName()}.${generatedClassName()}"

}
