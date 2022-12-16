package ru.vtb.configuration.server.controller

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.check.CheckRunner
import ru.vtb.configuration.server.controller.dto.TopicPut
import ru.vtb.configuration.server.controller.intf.FillDictController
import ru.vtb.configuration.server.repo.dto.*
import ru.vtb.configuration.server.repo.intf.FillDictRepository
import java.util.*

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
class FillDictControllerImpl(
    val fillDictRepository: FillDictRepository,
    val checkService: CheckRunner
) : FillDictController {
    override fun dictServiceInsert(graphId: String, serviceId: String, profileId: String, mainClass: String) {
        val graphFlinkServiceProfile =
            GraphFlinkServiceProfile(graphId, FlinkServiceProfile(FlinkService(serviceId, mainClass), profileId))
        fillDictRepository.dictServiceInsert(graphFlinkServiceProfile)
        checkService.checkAll()
    }

    override fun dictTopicInsertList(topics: List<TopicPut>, topicOwner: String) {
        topics.forEach {
            fillDictRepository.dictTopicInsert(it.graphId, it.topicName, topicOwner)
        }
        checkService.checkAll()
    }

    override fun dictTopicDelete(topicName: String) {
        fillDictRepository.dictTopicDelete(topicName)
        checkService.checkAll()
    }

    override fun dictServiceDelete(serviceId: String, profileId: String) {
        fillDictRepository.dictServiceDelete(serviceId, profileId)
    }

    override fun topicInsertListGraphProp(graphId: String, topicOwner: String, propFile: String) {
        val parsedProperty = parseProperty(propFile, ",")
            .filter { it.name.lowercase(Locale.getDefault()).contains("topic") }
            .map { TopicPut(graphId, it.value) }
        dictTopicInsertList(parsedProperty, topicOwner)
    }

    override fun dictArrowInsert(
        directionEnum: DirectionEnum,
        graphId: String,
        serviceId: String,
        profileId: String,
        topicName: String,
        propertyKey: String,
        kafkaPropertyGroup: String
    ): Unit {
        fillDictRepository.dictArrowInsert(directionEnum, graphId, serviceId, profileId, topicName, propertyKey,kafkaPropertyGroup)
        checkService.checkAll()
    }


    override fun flinkPropertyInsertByTextEnv(
        serviceId: String,
        profileId: String,
        propString: String
    ) {
        insert(" ", serviceId, profileId, propString)
    }

    override fun flinkPropertyDelete(serviceId: String, profileId: String, propId: String) {
        fillDictRepository.flinkPropertyDelete(serviceId, profileId, propId)
    }

    override fun flinkPropertyInsertByTextProp(
        serviceId: String,
        profileId: String,
        propString: String
    ) {
        insert("=", serviceId, profileId, propString)
    }

    private fun insert(
        delimiters: String,
        serviceId: String,
        profileId: String,
        propString: String
    ) {
        val parsedProperty = parseProperty(propString, delimiters)

        flinkPropertyInsertByList(serviceId, profileId, parsedProperty)
    }

    private fun parseProperty(
        propString: String,
        delimiters: String
    ): List<PropertyDto> {
        val split1 = propString
            .replace("`\"--", "")
            .replace("\"--", "")
            .replace(" \"`", "")
            .replace(" \"", "")
            .trim()
            .split("\n")

            .filter { it != "" }
        val parsedProperty = split1
            .map { propKeyVal ->

                val split = propKeyVal.trim().split(delimiters)
                assert(split.size == 2) { "not compatible string '$propKeyVal'" }
                val key = split[0].substring(split[0].indexOf(".") + 1)
                val value = split[1]
                key to value
            }.map { PropertyDto(it.first, it.second) }

        val map1 = parsedProperty
            .map { it.name }
            .groupBy { it }
            .filter { it.value.size != 1 }
            .map { it.key }
        val dublicate = map1
            .joinToString(",")

        assert(dublicate.isEmpty()) { "dublicate keys $dublicate" }
        return parsedProperty
    }

    override fun flinkPropertyInsertByList(
        serviceId: String,
        profileId: String,
        propsAndVal: List<PropertyDto>
    ) {
        propsAndVal.forEach { keyVal ->
            fillDictRepository.dictFlinkPropertyInsert(serviceId, profileId, keyVal)
        }
        checkService.checkAll()
    }

}