package ru.vood.configuration.server.backUp.dto

data class ColumnMeta(
    val name: String,
    val columnComment: String = "",
    val isInPrimaryKey: Boolean
)
