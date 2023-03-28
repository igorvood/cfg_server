package ru.vtb.jpaprocessor.generator.model

interface OrIsNullSearchMethod {
    fun name(): String
    fun entity(): OrIsNullClass
    fun filter(): OrIsNullClass
    fun query(): String
}