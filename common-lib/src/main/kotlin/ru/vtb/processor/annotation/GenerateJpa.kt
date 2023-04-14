package ru.vtb.processor.annotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE)
annotation class GenerateJpa(
    val tableComment: String,
    val genRest: Boolean,
    val readOnly: Boolean
)
