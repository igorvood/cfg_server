package ru.vtb.configuration.server.backUp.dto

data class TableMeta(
    val lvl: Int,
    val tableName: String,
    val columns: List<ColumnMeta>
)
