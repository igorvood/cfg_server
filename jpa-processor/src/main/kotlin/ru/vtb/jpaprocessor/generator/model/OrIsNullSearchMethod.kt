package ru.vtb.jpaprocessor.generator.model

interface OrIsNullSearchMethod {
    fun name(): String
    fun entity(): IAnnotatedClass
    fun filter(): IAnnotatedClass
    fun query(): String
}