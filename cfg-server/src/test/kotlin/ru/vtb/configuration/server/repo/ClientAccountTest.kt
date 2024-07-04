package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Test
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

class ClientAccountTest: AbstractDatasourceTests() {

    @Test
    fun accountInsert(){
//        подготовка данных
        jdbcTemplate.update(
            "insert into client(passport_num, passport_ser, fio, client_type) values (?, ?, ?, ?) ",
            "1",
            "1",
            "Тетушка Медоуз с дочками",
            "физик"
        )

        accInsert()
    }

    private fun accInsert() {
        jdbcTemplate.update(
            "insert into client_account(acc_num, client_id, currency) values (?, ?, ?) ",
            "123456789",
            "1_1",
            "rub"
        )
    }


}