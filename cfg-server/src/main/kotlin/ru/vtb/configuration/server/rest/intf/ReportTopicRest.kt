package ru.vtb.configuration.server.rest.intf

import ru.vtb.configuration.server.repo.dto.StandEnum

interface ReportTopicRest {
    fun topicsByStand(standEnum: StandEnum): List<String>

    fun usedTopics(): Set<String>

    fun unUsedTopics(): Set<String>
}