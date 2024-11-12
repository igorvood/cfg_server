package ru.vood.configuration.server.rest.intf

import ru.vood.configuration.server.repo.dto.StandEnum

interface ReportTopicRest {
    fun topicsByStand(standEnum: StandEnum): List<String>

    fun usedTopics(): Set<String>

    fun unUsedTopics(): Set<String>
}