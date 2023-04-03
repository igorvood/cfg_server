package ru.vtb.jpaprocessor.generator.model

interface OrIsNullSearchMethod {
    fun name(): String
    fun entity(): AbstractAnnotatedClass
    fun filter(): AbstractAnnotatedClass
    fun query(): String
}