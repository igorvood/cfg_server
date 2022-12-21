package ru.vtb.configuration.server.ui

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository

@Repository
class UiRepository(
    private val jdbcTemplate: JdbcOperations
) {

    fun tablesMeta(){

    }
}