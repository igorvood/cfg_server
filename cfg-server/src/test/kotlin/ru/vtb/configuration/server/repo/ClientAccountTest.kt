package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Test
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

class ClientAccountTest: AbstractDatasourceTests() {

    @Test
    fun accountInsert(){

        jdbcTemplate.update("insert into client_account(acc_num, client_id, currency) values ?, ? ? ", "123456789", "1_1", "rub")
    }




}