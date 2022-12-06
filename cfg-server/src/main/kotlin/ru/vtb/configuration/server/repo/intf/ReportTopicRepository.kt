package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.repo.dto.TopicForReport

interface ReportTopicRepository {

    fun topicsByStand(standEnum: StandEnum): List<String>

    fun usedTopics(): List<String>

    fun unUsedTopics(): Set<String>

    fun repTopics(groupId: String, stand: StandEnum): Set<TopicForReport>
}