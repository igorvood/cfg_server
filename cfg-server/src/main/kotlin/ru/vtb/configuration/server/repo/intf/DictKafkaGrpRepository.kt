package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.controller.dto.KafkaPropertyGrp
import ru.vtb.configuration.server.repo.dto.PropertyDto

interface DictKafkaGrpRepository {


    fun kafkaPropertyGrpList(): Set<KafkaPropertyGrp>

    fun kafkaPropertyGrp(grpId: String, direction: Direction): Set<PropertyDto>

    fun kafkaPropertyGrpDelete(grpId: String, direction: Direction)

    fun kafkaPropertyGrpAdd(grpId: String, direction: Direction, description: String)

    fun kafkaPropertyEdit(grpId: String, direction: Direction, propertyRestDto: PropertyDto)

    fun kafkaPropertyAdd(grpId: String, direction: Direction, propertyRestDto: PropertyDto)
}
