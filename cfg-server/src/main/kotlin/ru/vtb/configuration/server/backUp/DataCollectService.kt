package ru.vtb.configuration.server.backUp

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.backUp.dto.ColumnMeta
import java.math.BigDecimal
import java.util.ListResourceBundle

@Repository
class DataCollectService(
    private val dataBackUpRepository: DataBackUpRepository
) {

    fun exportData(tableName: List<String> = listOf()): String {

        val metaData = getMeta(tableName)

        val map = metaData
            .map { table ->
                val columnsList = table.columns

                val columnList = columnsList.joinToString(", ") { it.name }
                val dataTable = dataBackUpRepository.allTableData("""select $columnList from ${table.tableName}""")
                table to Data(columnsList, columnList, dataTable)
            }
            .joinToString("\n") { td ->
                val table = td.first
                val dataTable = td.second

                dataTable.data
                    .joinToString("\n") { cellDataTable ->
                        generateInsert(table.columns, cellDataTable, table.tableName, dataTable.colsStr)
                    }
            }
        return map
    }

    private fun getMeta(tableName: List<String>) = when (tableName.size) {
        1 -> dataBackUpRepository.metaDataByTable(tableName[0])
        0 -> dataBackUpRepository.metaDataByTable()
        else -> dataBackUpRepository.metaDataByTable()
            .filter { t -> tableName.contains(t.tableName) }
            .sortedBy { "${it.lvl}_${it.tableName}" }
    }

    private fun generateInsert(
        columns: List<ColumnMeta>,
        cellDataTable1: MutableMap<String, Any>,
        tableName: String,
        colsStr: String
    ): String {
        val columnsVal = columns.joinToString(", ") { cm ->

            val sd = when (val rowData = cellDataTable1[cm.name]) {
                null -> "null"
                is String -> "'${rowData}'"
                is BigDecimal -> rowData.toString()
                is Integer -> rowData.toString()
                else -> throw IllegalStateException("Не поддерживаемый тип $rowData")
            }
            sd
        }

        return """insert into $tableName($colsStr) VALUES ($columnsVal);"""
    }

    @Transactional
    fun importData(tableNames: List<String>, generateInsertsQuery: String) {
        val meta = getMeta(tableNames)
        dataBackUpRepository.cleanTables(meta)
        val sqls = generateInsertsQuery.split("\n")
        dataBackUpRepository.runQueries(sqls)
    }

    data class Data(
        val cols: List<ColumnMeta>,
        val colsStr: String,
        val data: List<MutableMap<String, Any>>
    )

}