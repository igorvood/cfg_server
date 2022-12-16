package ru.vtb.configuration.server.rest.intf

import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.rest.TopicWithDirection

interface FillDictRest {

    fun dictServiceInsert(
        graphId: String, serviceId: String, mainClass: String,
        profileId: String,
    )

    fun dictServiceInsertPath(graphId: String, serviceId: String, profileId: String, mainClass: String)

    fun dictTopicInsert(graphId: String, topicOwner: String, topicName: String)
    fun flinkPropertyInsertByTextEnv(serviceId: String, profileId: String, propString: String)
    fun flinkPropertyInsertSingleProperty(serviceId: String, profileId: String, propId: String, propValue: String)
    fun flinkPropertyInsertList(serviceId: String, profileId: String, props: List<PropertyDto>)

    //    fun dictTopicListInsert(topics: List<TopicPut>)
    fun topicInsertListGraph(graphId: String, topicOwner: String, topics: Set<String>)
    fun dictServiceInsertList(
        graphId: String,
        serviceId: String,
        mainClass: String,
        profileIds: Set<String>
    )

    fun dictArrowInsertList(
        graphId: String,
        serviceId: String,
        profileId: String,
        topics: Set<TopicWithDirection>
    )

    fun dictArrowInsert(
        graphId: String,
        serviceId: String,
        profileId: String,
        directionEnum: DirectionEnum,
        topicName: String,
        propertyKey: String,
        kafkaPropertyGroup: String,
    )

    fun flinkPropertyInsertByTextProp(serviceId: String, profileId: String, propString: String)

    fun dictServiceDelete(serviceId: String, profileId: String)
    fun dictTopicDelete(topicName: String)
    fun flinkPropertyDelete(serviceId: String, profileId: String, propId: String)
}