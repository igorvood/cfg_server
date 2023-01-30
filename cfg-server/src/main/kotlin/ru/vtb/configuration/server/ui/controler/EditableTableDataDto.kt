package ru.vtb.configuration.server.ui.controler

import ru.vtb.configuration.server.backUp.dto.ColumnMeta

data class EditableTableDataDto(
    val tableId: String,
    val tableComment: String,
    val columns: List<ColumnMeta>,
    val tableData: List<TableMetaController.RowData>,
)
