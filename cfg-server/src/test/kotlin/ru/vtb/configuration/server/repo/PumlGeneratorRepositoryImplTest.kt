package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class PumlGeneratorRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var pumlGeneratorRepositoryImplTest: PumlGeneratorRepositoryImpl

    @Test
    fun findByGraphId() {
        val findByGraphId = pumlGeneratorRepositoryImplTest.findByGraphId("rto_graph")
        assertEquals(101, findByGraphId.size)
    }

    @Test
    fun findByTopic() {
        val findByGraphId = pumlGeneratorRepositoryImplTest.findByTopic("rto_graph")
        assertEquals(0, findByGraphId.size)
    }

    @Test
    fun findByGroupId() {
        val findByGraphId = pumlGeneratorRepositoryImplTest.findByGroupId("rto_graph")
        assertEquals(101, findByGraphId.size)

    }
}