package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.controller.dto.KafkaPropertyGrp
import ru.vtb.configuration.server.controller.intf.DictKafkaGrpController
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.rest.intf.DictKafkaGrp


@RestController
class DictKafkaGrpImpl(val dictKafkaGrpController: DictKafkaGrpController) : DictKafkaGrp {

    @Operation(summary = "Список групп свойств кафки ", tags = ["Заполнение таблиц. Группы свойств кафки."])
    @GetMapping("/kafkaPropertyGrp")
    override fun kafkaPropertyGrp(
        @RequestParam
        grpId: String,
        @RequestParam
        direction: Direction,
    ): Set<PropertyDto> {
        return dictKafkaGrpController.kafkaPropertyGrp(grpId, direction)
    }

    @Operation(summary = "Свойства группы свойств кафки ", tags = ["Заполнение таблиц. Группы свойств кафки."])
    @GetMapping("/kafkaPropertyGrpList")
    override fun kafkaPropertyGrpList(): Set<KafkaPropertyGrp> {
        return dictKafkaGrpController.kafkaPropertyGrpList()
    }

    @Operation(summary = "Удаление группы свойств кафки ", tags = ["Заполнение таблиц. Группы свойств кафки."])
    @DeleteMapping("/kafkaPropertyDelete")
    override fun kafkaPropertyDelete(grpId: String, direction: Direction) {
        dictKafkaGrpController.kafkaPropertyDelete(grpId, direction)
    }


    @Operation(summary = "Редактирование группы свойств кафки ", tags = ["Заполнение таблиц. Группы свойств кафки."])
    @PostMapping("/kafkaPropertyEdit")
    override fun kafkaPropertyEdit(grpId: String, direction: Direction, propertyRestDto: PropertyDto) {
        dictKafkaGrpController.kafkaPropertyEdit(grpId, direction, propertyRestDto)
    }

    @Operation(summary = "Добавление группы свойств кафки ", tags = ["Заполнение таблиц. Группы свойств кафки."])
    @PutMapping("/kafkaPropertyGrpAdd")
    override fun kafkaPropertyGrpAdd(grpId: String, direction: Direction, description: String) {
        dictKafkaGrpController.kafkaPropertyGrpAdd(grpId, direction, description)
    }


    @Operation(summary = "Добавление свойства кафки в группу ", tags = ["Заполнение таблиц. Группы свойств кафки."])
    @PutMapping("/kafkaPropertyAdd")
    override fun kafkaPropertyAdd(grpId: String, direction: Direction, propertyRestDto: PropertyDto) {
        dictKafkaGrpController.kafkaPropertyAdd(grpId, direction, propertyRestDto)
    }
}