package ru.vtb.configuration.server.backUp

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.backUp.dto.ColumnMeta
import ru.vtb.configuration.server.backUp.dto.TableMeta
import java.sql.CallableStatement
import java.sql.ResultSet

@Repository
class DataBackUpRepository(
    private val jdbcTemplate: JdbcOperations
) {

    // TODO: 15.12.2022 Эти данные не меняются, сюда надо прикрутить кеш и запрос делать из кеша
    fun metaDataByTable(inTableName: String? = null): List<TableMeta> {
        val query = jdbcTemplate.query(
            PreparedStatementCreator { con ->
                val cs: CallableStatement =
                    con.prepareCall(
                        """select lvl, table_name, column_name 
                            from pdd_back_up 
                            where table_name = ? or ? is null """
                    )
                cs.setString(1, inTableName)
                cs.setString(2, inTableName)
                cs
            },
            ResultSetExtractor { rs: ResultSet ->

                val res = mutableMapOf<Pair<Int, String>, MutableList<ColumnMeta>>()

                while (rs.next()) {

                    val lvl = rs.getInt(1)
                    val tableName = rs.getString(2)

                    val t = lvl to tableName

                    val columns = res.computeIfAbsent(t) { mutableListOf() }

                    columns.add(ColumnMeta(rs.getString(3)))

                }
                res.entries
                    .map { s -> TableMeta(s.key.first, s.key.second, s.value.sortedBy { it.name }) }
                    .sortedBy { sortFun(it) }
                    .distinct()

            }
        )
        return query ?: listOf()
    }

    fun allTableData(sql: String): List<MutableMap<String, Any>> {
        return jdbcTemplate.queryForList(sql)
    }

    @Transactional(propagation = Propagation.MANDATORY)
    fun cleanTables(meta: List<TableMeta>) {
        meta.sortedByDescending { sortFun(it) }
            .forEach { jdbcTemplate.update("delete from ${it.tableName}") }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    fun runQueries(sqls: List<String>) {
        sqls
            .forEach { jdbcTemplate.update(it) }
    }

    private fun sortFun(it: TableMeta) = "${it.lvl}_${it.tableName}"

}