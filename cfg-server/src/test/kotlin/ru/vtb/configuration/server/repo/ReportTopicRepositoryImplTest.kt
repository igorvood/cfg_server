package ru.vtb.configuration.server.repo

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
        assert(topicsByStand.isNotEmpty())
    }

    @Test
    fun usedTopics() {
        val topicsByStand = reportTopicRepositoryImpl.usedTopics()
        assert(topicsByStand.isNotEmpty())
    }

    @Test
    fun unUsedTopics() {
        val topicsByStand = reportTopicRepositoryImpl.unUsedTopics()
        assert(topicsByStand.isNotEmpty())
    }

    @Test
    fun repTopics() {
        val repTopics = reportTopicRepositoryImpl.repTopics("rto_graph", StandEnum.P0)
        assert(repTopics.isNotEmpty())
    }
}