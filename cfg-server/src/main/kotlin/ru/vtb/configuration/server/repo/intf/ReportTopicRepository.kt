package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.repo.dto.StandEnum

interface ReportTopicRepository {

    fun topicsByStand(standEnum: StandEnum): List<String>

    fun usedTopics(): List<String>

    fun unUsedTopics(): Set<String>
}