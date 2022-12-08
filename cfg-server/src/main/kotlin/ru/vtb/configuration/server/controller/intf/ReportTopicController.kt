package ru.vtb.configuration.server.controller.intf

import ru.vtb.configuration.server.repo.dto.StandEnum

interface ReportTopicController {
    fun topicsByStand(standEnum: StandEnum): List<String>

    fun usedTopics(): Set<String>

    fun unUsedTopics(): Set<String>

    fun repTopics(groupId: String, stand: StandEnum): ByteArray
}