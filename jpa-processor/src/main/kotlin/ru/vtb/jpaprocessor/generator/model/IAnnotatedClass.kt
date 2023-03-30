package ru.vtb.jpaprocessor.generator.model

interface IAnnotatedClass/*<Annotation>*/ {
    fun name(): String

    fun shortName(): String {
        val dotIdx = name().lastIndexOf('.')
        return name().substring(dotIdx + 1)
    }

    fun packageName(): String {
        val dotIdx = name().lastIndexOf('.')
        return name().substring(0, dotIdx)
    }

    fun fields(): List<OrIsNullField>
}