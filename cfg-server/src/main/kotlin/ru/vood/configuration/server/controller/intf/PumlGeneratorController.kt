package ru.vood.configuration.server.controller.intf

import ru.vood.configuration.server.repo.dto.DirectionEnum

interface PumlGeneratorController {

    fun generatePumlByGraphId(graphId: String): String
    fun generatePumlByTopic(topicId: String, directionEnum: DirectionEnum): String
}