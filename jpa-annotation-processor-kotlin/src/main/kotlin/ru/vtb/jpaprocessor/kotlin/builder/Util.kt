package ru.vtb.jpaprocessor.kotlin.builder


fun String.mapKotlinType(): String = if (this == "java.lang.String") {
    "String"
} else this

