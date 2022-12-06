package ru.vtb.configuration.server.controller.intf

import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.controller.dto.TopicPut

interface FillDictController {

    fun dictServiceInsert(graphId: String, serviceId: String, profileId: String, mainClass: String)
    fun dictTopicInsertList(topics: List<TopicPut>, topicOwner: String)
    fun dictServiceDelete(serviceId: String, profileId: String)

    fun topicInsertListGraphProp(graphId: String, topicOwner: String, propFile: String)

    fun dictArrowInsert(
        directionEnum: DirectionEnum,
        graphId: String,
        serviceId: String,
        profileId: String,
        topicName: String,
        propertyKey: String
    )

    fun flinkPropertyInsertByTextEnv(serviceId: String, profileId: String, propString: String)
    fun flinkPropertyInsertByList(serviceId: String, profileId: String, propsAndVal: List<PropertyDto>)
    fun flinkPropertyInsertByTextProp(serviceId: String, profileId: String, propString: String)
    fun dictTopicDelete(topicName: String)
    fun flinkPropertyDelete(serviceId: String, profileId: String, propId: String)

}