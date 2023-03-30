package ru.vtb.jpaprocessor.generator.model

interface GeneratedClass {

    fun generatedClassName(): String

    fun generatedPackageName(): String

    fun fullGeneratedName(): String = "${generatedPackageName()}.${generatedClassName()}"

}
