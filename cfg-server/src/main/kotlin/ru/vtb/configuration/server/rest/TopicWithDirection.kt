package ru.vtb.configuration.server.rest

import ru.vtb.configuration.server.repo.dto.DirectionEnum

data class TopicWithDirection(
    val directionEnum: DirectionEnum,

    val topicName: String,
    val propertyKey: String,
    val propertyGroup: String


)
