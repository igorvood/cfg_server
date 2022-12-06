package ru.vtb.configuration.server.test.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.springframework.transaction.IllegalTransactionStateException

inline fun assertTransaction(executable: () -> Unit): Unit {
    val message = assertThrows<IllegalTransactionStateException> {
        executable()
    }.message

    Assertions.assertEquals(
        "No existing transaction found for transaction marked with propagation 'mandatory'",
        message
    )
}
