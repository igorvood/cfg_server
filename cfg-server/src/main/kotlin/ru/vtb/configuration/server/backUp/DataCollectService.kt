package ru.vtb.configuration.server.backUp

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.backUp.dto.ColumnMeta
import java.math.BigDecimal

@Repository
class DataCollectService(
    private val dataBackUpRepository: DataBackUpRepository
) {

    fun exportData(tableName: List<String> = listOf()): String {

        val metaData = getMeta(tableName)

        val map = metaData
            .sortedBy { it.lvl.toString() + "_" + it.tableName }
            .map { table ->
                val columnsList = table.columns

                val columnList = columnsList.joinToString(", ") { it.name }
                val dataTable = dataBackUpRepository.allTableData("""select $columnList from ${table.tableName}""")
                table to Data(columnsList, columnList, dataTable)
            }
            .joinToString(";\n\n") { td ->
                val table = td.first
                val dataTable = td.second

                if (dataTable.data.isNotEmpty()) {
                    "insert into ${table.tableName}(${dataTable.colsStr}) \n" +
                            dataTable.data
                                .joinToString(" union \n") { cellDataTable ->
                                    generateInsert(table.columns, cellDataTable, table.tableName, dataTable.colsStr)
                                }
                } else ""

            }
        return map
    }

    private fun getMeta(tableName: List<String>) = when (tableName.size) {
        1 -> dataBackUpRepository.metaDataByTable(tableName[0])
        0 -> dataBackUpRepository.metaDataByTable()
        else -> tableName
            .flatMap { dataBackUpRepository.metaDataByTable(it) }
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

        return """select $columnsVal from dual """
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun importData(tableNames: List<String>, generateInsertsQuery: String) {
        val meta = getMeta(tableNames)
        dataBackUpRepository.cleanTables(meta)
        val sqls = generateInsertsQuery.split("~\\~")
        dataBackUpRepository.runQueries(sqls)
    }

    data class Data(
        val cols: List<ColumnMeta>,
        val colsStr: String,
        val data: List<MutableMap<String, Any>>
    )

}