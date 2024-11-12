package ru.vood.configuration.server.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.configuration.server.repo.dto.StandEnum
import ru.vood.configuration.server.abstraction.AbstractTests

internal class ReportTopicControllerImplTest : AbstractTests() {

    @Autowired
    lateinit var reportTopicControllerImpl: ReportTopicControllerImpl

    @Test
    fun topicsByStand() {
    }

    @Test
    fun usedTopics() {
    }

    @Test
    fun unUsedTopics() {
    }

    @Test
    fun repTopics() {
        reportTopicControllerImpl.repTopics("rto_graph", StandEnum.P0)

    }

    @Test
    fun getReportTopicRepository() {
    }
}