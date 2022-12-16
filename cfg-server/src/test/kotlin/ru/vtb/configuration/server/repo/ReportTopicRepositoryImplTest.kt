package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class ReportTopicRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var reportTopicRepositoryImpl: ReportTopicRepositoryImpl

    @Test
    fun topicsByStand() {
        val topicsByStand = reportTopicRepositoryImpl.topicsByStand(StandEnum.DSO)
        assertEquals(60, topicsByStand.size)
    }

    @Test
    fun usedTopics() {
        val topicsByStand = reportTopicRepositoryImpl.usedTopics()
        assertEquals(52, topicsByStand.size)
    }

    @Test
    fun unUsedTopics() {
        val topicsByStand = reportTopicRepositoryImpl.unUsedTopics()
        assertEquals(1, topicsByStand.size)
    }

    @Test
    fun repTopics() {
        val repTopics = reportTopicRepositoryImpl.repTopics("rto_graph", StandEnum.P0)
        assertEquals(52, repTopics.size)
    }
}