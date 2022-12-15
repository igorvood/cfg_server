package ru.vtb.configuration.server.backUp

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.test.abstraction.compareTablesWithAsserts
import kotlin.test.assertEquals

internal class FullBackupTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dataCollectService: DataCollectService


    @Test
    fun generateInsertsQueryOneTable() {

        val tableNames = jdbcTemplate.query(
            "select original_name, backup_name from tst_backedup_table_cache"
        ) { rs, _ ->
            Pair(
                rs.getString(1),
                rs.getString(2)
            )
        }

        val map = tableNames.map { it.first }
        val generateInsertsQuery = dataCollectService.exportData(map)
        println(generateInsertsQuery)

        assertEquals(18, tableNames.size)

        dataCollectService.importData(tableNames.map { it.first }, generateInsertsQuery)

        tableNames.forEach {
            jdbcTemplate.compareTablesWithAsserts(it.first, it.second)
        }
    }
}