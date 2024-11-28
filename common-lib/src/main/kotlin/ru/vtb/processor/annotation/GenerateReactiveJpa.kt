package ru.vtb.processor.annotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE)
annotation class GenerateReactiveJpa(
    val tableComment: String,
    val genRest: Boolean,
)
