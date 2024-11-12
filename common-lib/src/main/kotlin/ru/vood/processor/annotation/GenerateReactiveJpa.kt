package ru.vood.processor.annotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE)
annotation class GenerateReactiveJpa(
    val tableComment: String,
    val genRest: Boolean,
)
