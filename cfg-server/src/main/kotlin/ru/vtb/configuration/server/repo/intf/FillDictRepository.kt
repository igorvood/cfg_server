package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.dto.GraphFlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.PropertyDto

interface FillDictRepository {

    fun dictServiceInsert(graphFlinkServiceProfile: GraphFlinkServiceProfile)

    fun dictServiceDelete(serviceId: String, profileId: String): Int

    fun dictTopicInsert(graphId: String, topicName: String, owner: String)

    fun dictArrowInsert(
        directionEnum: DirectionEnum,
        graphId: String,
        serviceId: String,
        profileId: String,
        topicName: String,
        propertyKey: String,
        kafkaPropertyGroup: String,
    )

    fun dictFlinkPropertyInsert(serviceId: String, profileId: String, propertyDto: PropertyDto)
    fun dictTopicDelete(topicName: String): Int
    fun flinkPropertyDelete(serviceId: String, profileId: String, propId: String)

}