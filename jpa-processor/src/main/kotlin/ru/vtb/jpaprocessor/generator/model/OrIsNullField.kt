package ru.vtb.jpaprocessor.generator.model

interface OrIsNullField {
    fun name(): String
    fun type(): String
    fun betterClass(): AbstractAnnotatedClass?
}