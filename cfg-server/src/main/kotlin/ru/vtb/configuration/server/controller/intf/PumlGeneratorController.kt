package ru.vtb.configuration.server.controller.intf

import ru.vtb.configuration.server.repo.dto.DirectionEnum

interface PumlGeneratorController {

    fun generatePumlByGraphId(graphId: String): String
    fun generatePumlByTopic(topicId: String, directionEnum: DirectionEnum): String
}