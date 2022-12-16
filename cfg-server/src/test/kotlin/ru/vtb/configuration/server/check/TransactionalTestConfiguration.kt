package ru.vtb.configuration.server.check

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TransactionalTestConfiguration {

    @Bean
    fun transactionTestBeanPostProcessor() = TransactionTestBeanPostProcessor()
}