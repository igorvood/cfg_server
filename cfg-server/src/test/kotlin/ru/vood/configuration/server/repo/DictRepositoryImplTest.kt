package ru.vood.configuration.server.repo

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import ru.vood.configuration.server.repo.dto.FlinkService
import ru.vood.configuration.server.repo.dto.FlinkServiceProfile
import ru.vood.configuration.server.repo.dto.Graph
import ru.vood.configuration.server.abstraction.AbstractDatasourceTests
import kotlin.test.assertContains
import kotlin.test.assertEquals

internal class DictRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictRepositoryImpl: DictRepositoryImpl

    val serviceId = "uasp-streaming-mdm-enrichment"
    val mainClass = "ru.vood.uasp.mdm.enrichment.EnrichmentJob"

    @Test
    fun graphList() {
        val graphList = dictRepositoryImpl.graphList()
            .filter { it.graphId == "rto_graph" }
            .toSet()
        assertEquals(setOf(Graph("rto_graph")), graphList)
    }

    @Test
    fun serviceList() {

        val graphList = dictRepositoryImpl.serviceList()
            .filter { it.id == serviceId }
            .toSet()

        assertEquals(setOf(FlinkService(serviceId, mainClass)), graphList)
    }

    @Test
    fun serviceById() {
        val graphList = dictRepositoryImpl.serviceById(serviceId)
        assertEquals(FlinkService(serviceId, mainClass), graphList)

    }

    @Test
    fun serviceProfile() {
        val graphList = dictRepositoryImpl.serviceProfile(serviceId)
        assertContains(graphList, FlinkServiceProfile(FlinkService(serviceId, mainClass), "case-68"))
    }
}