package ru.vtb.configuration.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableR2dbcRepositories
class ReactiveConfigurationServerApplication

fun main(args: Array<String>) {
    runApplication<ReactiveConfigurationServerApplication>(*args)
}
