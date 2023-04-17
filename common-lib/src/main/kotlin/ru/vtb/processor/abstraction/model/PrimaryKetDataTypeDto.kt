package ru.vtb.processor.abstraction.model

import ru.vtb.jpaprocessor.kotlin.builder.mapKotlinType


data class PrimaryKetDataTypeDto(val javaDataType: String,
                                 val isScalarType: Boolean,
){


    val kotlinDataType: String = javaDataType.mapKotlinType()
}
