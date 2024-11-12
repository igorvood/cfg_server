package ru.vood.processor.abstraction.model

import ru.vood.processor.abstraction.model.abstraction.mapKotlinType


data class PrimaryKetDataTypeDto(
    val javaDataType: String,
    val isScalarType: Boolean,
) {


    val kotlinDataType: String = javaDataType.mapKotlinType()
}
