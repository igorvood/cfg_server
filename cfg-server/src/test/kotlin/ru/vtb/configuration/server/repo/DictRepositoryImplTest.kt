package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class DictRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictRepositoryImpl: DictRepositoryImpl


    @Test
    fun graphList() {
    }

    @Test
    fun serviceList() {
    }

    @Test
    fun serviceById() {
    }

    @Test
    fun serviceProfile() {
    }
}