package ru.vtb.processor.abstraction.model

import ru.vtb.processor.abstraction.model.abstraction.mapKotlinType


data class PrimaryKetDataTypeDto(val javaDataType: String,
                                 val isScalarType: Boolean,
){


    val kotlinDataType: String = javaDataType.mapKotlinType()
}
