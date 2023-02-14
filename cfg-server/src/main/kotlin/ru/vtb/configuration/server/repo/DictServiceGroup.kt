package ru.vtb.configuration.server.repo

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.PreparedStatementCallback
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Repository
import java.sql.CallableStatement

interface DictServiceGroupRepository {
    fun fillDefaultTracerGroup()
}

@Repository
class DictServiceGroupImpl(private val jdbcTemplate: JdbcOperations) : DictServiceGroupRepository {

    override fun fillDefaultTracerGroup() {
        jdbcTemplate.execute(PreparedStatementCreator { con ->
            val cs: CallableStatement = con.prepareCall(
                """select create_default_service_group()"""
            )
            cs
        }, PreparedStatementCallback { ps ->
            ps.execute()
            1
        })


    }
}