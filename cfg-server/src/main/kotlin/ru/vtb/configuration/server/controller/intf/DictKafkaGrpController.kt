package ru.vtb.configuration.server.controller.intf

import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.controller.dto.KafkaPropertyGrp
import ru.vtb.configuration.server.repo.dto.PropertyDto

interface DictKafkaGrpController {
    fun kafkaPropertyGrpList(): Set<KafkaPropertyGrp>

    fun kafkaPropertyGrp(grpId: String, direction: Direction): Set<PropertyDto>

    fun kafkaPropertyDelete(grpId: String, direction: Direction)

    fun kafkaPropertyEdit(grpId: String, direction: Direction, propertyRestDto: PropertyDto)

    fun kafkaPropertyGrpAdd(grpId: String, direction: Direction, description: String)
    fun kafkaPropertyAdd(grpId: String, direction: Direction, propertyRestDto: PropertyDto)
}
