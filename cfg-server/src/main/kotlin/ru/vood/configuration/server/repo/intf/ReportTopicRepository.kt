package ru.vood.configuration.server.repo.intf

import ru.vood.configuration.server.repo.dto.StandEnum
import ru.vood.configuration.server.repo.dto.TopicForReport

interface ReportTopicRepository {

    fun topicsByStand(standEnum: StandEnum): List<String>

    fun usedTopics(): Set<String>

    fun unUsedTopics(): Set<String>

    fun repTopics(groupId: String, stand: StandEnum): Set<TopicForReport>
}