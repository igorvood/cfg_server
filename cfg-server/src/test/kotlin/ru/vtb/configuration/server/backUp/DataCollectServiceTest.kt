package ru.vtb.configuration.server.backUp

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.test.abstraction.compareTablesWithAsserts
import kotlin.test.assertEquals

internal class DataCollectServiceTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dataCollectService: DataCollectService


    @Test
    fun generateInsertsQueryOneTable() {

        val generateInsertsQuery = dataCollectService.exportData(listOf("test_1"))

        assertEquals(
            """insert into test_1(default_val, id, num) VALUES (-1, 'id_1', 45);
insert into test_1(default_val, id, num) VALUES (15, 'id_2', 45);""", generateInsertsQuery
        )
    }


    @Test
    fun generateInsertsQueryManyTable() {
        val tableNames = listOf("test_1", "test_1_1")
        val generateInsertsQuery = dataCollectService.exportData(tableNames)
        assert(generateInsertsQuery.isNotEmpty())

        jdbcTemplate.update("delete from test_1_1")
        jdbcTemplate.update("delete from test_1")

        dataCollectService.importData(tableNames, generateInsertsQuery)

        tableNames.forEach { jdbcTemplate.compareTablesWithAsserts(it, "${it}_back") }
    }
}