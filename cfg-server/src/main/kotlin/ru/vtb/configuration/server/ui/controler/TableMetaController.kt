package ru.vtb.configuration.server.ui.controler

import org.springframework.stereotype.Component
import ru.vtb.configuration.server.backUp.IDataBackUpRepository

@Component
class TableMetaController(private val dataBackUpRepository: IDataBackUpRepository) {


    fun tablesList(): Set<TableUiDto> {
        val metaDataByTable = dataBackUpRepository.metaDataByTable()
        return metaDataByTable.map { TableUiDto(it.tableName, it.tableComment) }.toSet()
    }

    fun tableData(tableName: String): EditableTableDataDto {
        val (lvl, tableId, tableComment, columns) = dataBackUpRepository.metaDataByTable(tableName)[0]
        val columnList = columns.joinToString(", ") { it.name }
        val tableData = dataBackUpRepository.allTableData("""select $columnList from ${tableName}""")
            .map { row ->
                val map = row.map { col -> ColData(col.key, col.value) }
                RowData(map)

            }

        return EditableTableDataDto(tableId, tableComment, columns.sortedBy { !it.isInPrimaryKey }, tableData)

    }

    data class RowData(
        val cols: List<ColData>
    )

    data class ColData(
        val colName: String,
        val data: Any
    )
}