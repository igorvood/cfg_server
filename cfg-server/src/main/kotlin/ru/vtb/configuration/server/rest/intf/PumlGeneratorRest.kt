package ru.vtb.configuration.server.rest.intf

import ru.vtb.configuration.server.repo.dto.DirectionEnum

interface PumlGeneratorRest {

    fun plantUMLNew(graphId: String): String

    fun generatePumlByTopic(topicId: String, directionEnum: DirectionEnum): String
}