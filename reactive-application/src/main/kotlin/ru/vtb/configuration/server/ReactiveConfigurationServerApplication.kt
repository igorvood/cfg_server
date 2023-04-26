package ru.vtb.configuration.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
//@EnableJpaRepositories
class ReactiveConfigurationServerApplication

fun main(args: Array<String>) {
    runApplication<ReactiveConfigurationServerApplication>(*args)
}
