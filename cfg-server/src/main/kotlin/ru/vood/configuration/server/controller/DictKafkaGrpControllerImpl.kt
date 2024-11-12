package ru.vood.configuration.server.controller

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vood.configuration.server.check.CheckRunner
import ru.vood.configuration.server.controller.dto.Direction
import ru.vood.configuration.server.controller.dto.KafkaPropertyGrp
import ru.vood.configuration.server.controller.intf.DictKafkaGrpController
import ru.vood.configuration.server.repo.dto.PropertyDto
import ru.vood.configuration.server.repo.intf.DictKafkaGrpRepository

@Service
class DictKafkaGrpControllerImpl(
    val dictKafkaGrpRepository: DictKafkaGrpRepository,
    val checkService: CheckRunner
) : DictKafkaGrpController {

    override fun kafkaPropertyGrpList(): Set<KafkaPropertyGrp> {
        return dictKafkaGrpRepository.kafkaPropertyGrpList()
    }

    override fun kafkaPropertyGrp(grpId: String, direction: Direction): Set<PropertyDto> {
        return dictKafkaGrpRepository.kafkaPropertyGrp(grpId, direction)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun kafkaPropertyDelete(grpId: String, direction: Direction) {
        dictKafkaGrpRepository.kafkaPropertyGrpDelete(grpId, direction)
        checkService.checkAll()
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun kafkaPropertyEdit(grpId: String, direction: Direction, propertyRestDto: PropertyDto) {
        dictKafkaGrpRepository.kafkaPropertyEdit(grpId, direction, propertyRestDto)
        checkService.checkAll()
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun kafkaPropertyGrpAdd(grpId: String, direction: Direction, description: String) {
        dictKafkaGrpRepository.kafkaPropertyGrpAdd(grpId, direction, description)
        checkService.checkAll()
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun kafkaPropertyAdd(grpId: String, direction: Direction, propertyRestDto: PropertyDto) {
        dictKafkaGrpRepository.kafkaPropertyAdd(grpId, direction, propertyRestDto)
        checkService.checkAll()
    }

}