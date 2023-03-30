package ru.vtb.jpaprocessor.generator.model

interface IGeneratedClass {

    fun generatedClassName(): String

    fun generatedPackageName(): String

    fun fullGeneratedName(): String = "${generatedPackageName()}.${generatedClassName()}"

}
