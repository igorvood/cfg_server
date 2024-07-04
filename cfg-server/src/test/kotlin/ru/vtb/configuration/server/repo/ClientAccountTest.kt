package ru.vtb.configuration.server.repo

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
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
        // test
        accInsert()
    }

    @ParameterizedTest
    @MethodSource("ru.vtb.configuration.server.repo.ClientAccountTest#testcaseData")
    fun accountInsertFk(testcase: TestCase){
//        подготовка данных
        jdbcTemplate.update(
            "insert into client(passport_num, passport_ser, fio, client_type) values (?, ?, ?, ?) ",
            testcase.passport_num,
            testcase.passport_ser,
            "Тетушка Медоуз с дочками",
            "физик"
        )
        // test
        when{
            testcase.expectedError != null->{
                kotlin.runCatching {  accInsert() }
                    .map { error("должно упасть с ошибкой $it") }
                    .getOrElse {
                        Assertions.assertEquals(it.message, testcase.expectedError)
                    }
            }
            else -> {
                accInsert()
            }

        }
    }

    private fun accInsert() {
        jdbcTemplate.update(
            "insert into client_account(acc_num, client_id, currency) values (?, ?, ?) ",
            "123456789",
            "1_1",
            "rub"
        )
    }


companion object{
    private val testData = listOf(
        TestCase("1", "1"),
        TestCase("1", "2","""PreparedStatementCallback; SQL [insert into client_account(acc_num, client_id, currency) values (?, ?, ?) ]; ERROR: insert or update on table "client_account" violates foreign key constraint "client_account_client_id_fk"
  Подробности: Key (client_id)=(1_1) is not present in table "client".; nested exception is org.postgresql.util.PSQLException: ERROR: insert or update on table "client_account" violates foreign key constraint "client_account_client_id_fk"
  Подробности: Key (client_id)=(1_1) is not present in table "client".""")
    )

    @JvmStatic
    private fun testcaseData() = testData
        .map { Arguments.of(it) }
}
data class TestCase(
    val passport_num: String,
    val passport_ser: String,
    val expectedError: String?=null
    )

}