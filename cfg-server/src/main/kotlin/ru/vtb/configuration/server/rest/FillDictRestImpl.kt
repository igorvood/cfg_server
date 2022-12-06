package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.controller.intf.FillDictController
import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.repo.dto.TopicPut
import ru.vtb.configuration.server.rest.intf.FillDictRest


@RestController
class FillDictRestImpl(
    val fillDictController: FillDictController
) : FillDictRest {

    @Operation(summary = "Создание сервиса с профилем", tags = ["Заполнение таблиц. Сервис."])
    @PutMapping("/serviceInsert", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun dictServiceInsert(
        graphId: String,
        serviceId: String,
        mainClass: String,
        profileId: String,
    ): Unit {
        fillDictController.dictServiceInsert(graphId, serviceId, profileId, mainClass)
    }

    @Operation(summary = "Удаление сервиса с профилем", tags = ["Заполнение таблиц. Сервис."])
    @DeleteMapping("/serviceDelete")
    override fun dictServiceDelete(
        serviceId: String,
        profileId: String,
    ) {
        fillDictController.dictServiceDelete(serviceId, profileId)
    }

    @Operation(summary = "Создание сервиса со списком профилей", tags = ["Заполнение таблиц. Сервис."])
    @PutMapping("/dictServiceInsertList", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun dictServiceInsertList(
        graphId: String,
        serviceId: String,
        mainClass: String,
        @RequestBody profileIds: Set<String>
    ): Unit {
        profileIds.forEach { fillDictController.dictServiceInsert(graphId, serviceId, it, mainClass) }
    }


    @Operation(
        summary = "Создание сервиса с профилем, альтернативный способ, Посмотрим что больше понравится разработке",
        tags = ["Заполнение таблиц. Сервис."]
    )
    @PutMapping(
        "/serviceInsertPath/{graphId}/{serviceId}/{profileId}/{mainClass}",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    override fun dictServiceInsertPath(
        @PathVariable graphId: String,
        @PathVariable serviceId: String,
        @PathVariable profileId: String,
        @PathVariable mainClass: String
    ): Unit {
        dictServiceInsert(graphId, serviceId, profileId, mainClass)
    }


    @Operation(summary = "Создание топика", tags = ["Заполнение таблиц. Топик"])
    @PutMapping("/topicInsert")
    override fun dictTopicInsert(graphId: String, topicOwner: String, topicName: String) {
        fillDictController.dictTopicInsertList(listOf(TopicPut(graphId, topicName)),topicOwner)
    }

    @Operation(summary = "удаление топика", tags = ["Заполнение таблиц. Топик"])
    @DeleteMapping("/topicDelete", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun dictTopicDelete(@RequestParam topicName: String) {
        fillDictController.dictTopicDelete(topicName)
    }


    /* @Operation(summary = "Создание топиков, списком", tags = ["Заполнение таблиц. Топик"])
     @PutMapping("/topicInsertList", produces = [MediaType.APPLICATION_JSON_VALUE])
     override fun dictTopicListInsert(
         @RequestBody topics: List<TopicPut>
     ) {
         fillDictController.dictTopicInsertList(topics)
     }*/

    @Operation(summary = "Создание топиков, списком", tags = ["Заполнение таблиц. Топик"])
    @PutMapping("/topicInsertListGraph", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun topicInsertListGraph(
        graphId: String,
        topicOwner: String,
        @RequestBody topics: Set<String>
    ) {
        fillDictController.dictTopicInsertList(topics.map { TopicPut(graphId, it) },topicOwner)
    }


    @Operation(summary = "Создание связи топика и сервиса", tags = ["Заполнение таблиц. Связи"])
    @PutMapping("/arrowInsert", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun dictArrowInsert(
        graphId: String,
        serviceId: String,
        profileId: String,
        directionEnum: DirectionEnum,
        topicName: String,
        propertyKey: String
    ) = fillDictController.dictArrowInsert(directionEnum, graphId, serviceId, profileId, topicName, propertyKey)

    @Operation(summary = "Создание связи топиков и сервиса, списком", tags = ["Заполнение таблиц. Связи"])
    @PutMapping("/dictArrowInsertList", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun dictArrowInsertList(
        graphId: String,
        serviceId: String,
        profileId: String,
        @RequestBody topics: Set<TopicWithDirection>

    ) {
        topics.forEach {
            fillDictController.dictArrowInsert(
                it.directionEnum,
                graphId,
                serviceId,
                profileId,
                it.topicName,
                it.propertyKey
            )
        }

    }

    @Operation(
        summary = "Создание настроек сервиса, вытаскиваются из текста ENV свойств",
        tags = ["Заполнение таблиц. Свойства сервиса"]
    )
    @PutMapping("/flinkPropertyInsertByTextEnv", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun flinkPropertyInsertByTextEnv(
        serviceId: String,
        profileId: String,
        @RequestBody propString: String
    ) = fillDictController.flinkPropertyInsertByTextEnv(serviceId, profileId, propString)

    @Operation(
        summary = "Создание настроек сервиса, вытаскиваются из текста PROP свойств",
        tags = ["Заполнение таблиц. Свойства сервиса"]
    )
    @PutMapping("/flinkPropertyInsertByTextProp", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun flinkPropertyInsertByTextProp(
        serviceId: String,
        profileId: String,
        @RequestBody propString: String
    ) = fillDictController.flinkPropertyInsertByTextProp(serviceId, profileId, propString)


    @Operation(summary = "Создание настройки сервиса", tags = ["Заполнение таблиц. Свойства сервиса"])
    @PutMapping("/flinkPropertyInsertSingleProperty", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun flinkPropertyInsertSingleProperty(
        serviceId: String,
        profileId: String,
        propId: String,
        propValue: String,
    ) = fillDictController.flinkPropertyInsertByList(serviceId, profileId, listOf(PropertyDto(propId, propValue)))

    @Operation(summary = "Удаление настройки сервиса", tags = ["Заполнение таблиц. Свойства сервиса"])
    @DeleteMapping("/flinkPropertyDelete", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun flinkPropertyDelete(
        serviceId: String,
        profileId: String,
        propId: String,
    ) = fillDictController.flinkPropertyDelete(serviceId, profileId, propId)

    @Operation(summary = "Создание настроек сервиса из списка", tags = ["Заполнение таблиц. Свойства сервиса"])
    @PutMapping("/flinkPropertyInsertList", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun flinkPropertyInsertList(
        serviceId: String,
        profileId: String,
        @RequestBody props: List<PropertyDto>,
    ) = fillDictController.flinkPropertyInsertByList(serviceId, profileId, props)
}