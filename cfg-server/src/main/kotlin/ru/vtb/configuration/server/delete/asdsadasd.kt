package ru.vtb.configuration.server.delete

import io.swagger.v3.oas.annotations.Operation
import org.springframework.data.repository.findByIdOrNull

import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.toImmutable


@RestController
@RequestMapping(path = ["/AAAAAAA"])

class asdsadasd(val dictTopicParamsByStandEntityGeneratedRepository: DictTopicParamsByStandEntityGeneratedRepository) {


    @Operation(summary = "Редактировать значение.", tags = ["Генерированное API. Настройки топика в разрезе стенда(DictTopicParamsByStandEntity)"])
    @PutMapping("/editEntity11", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity(
        @RequestBody editData: DictTopicParamsByStandEntityRestEdit
    ): DictTopicParamsByStandEntityImmutable? {
        val findByIdOrNull = dictTopicParamsByStandEntityGeneratedRepository.findByIdOrNull(editData.primaryKey)
        return findByIdOrNull?.let { oldData ->
            dictTopicParamsByStandEntityGeneratedRepository.save(
                oldData.apply {
                    this@apply.nodeId = editData.newData.nodeId
                    this@apply.standId = editData.newData.standId
                    this@apply.cntPartition = editData.newData.cntPartition
                    this@apply.topicName = editData.newData.topicName
                }).toImmutable()
        }
    }


    @Operation(summary = "aaaaРaaедактировать значение.", tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @PostMapping("/aaaaaa1", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity(
        @RequestBody editData: DictTopicOwnerEntityRestEdit
    ) = editData

    @Operation(summary = "aaaaРaaедактировать значение.", tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @PostMapping("/aaaaaa2", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity1(
        @RequestBody editData: DictAbstractGraphNodeEntityRestEdit
    ) = editData


    @Operation(summary = "aaaaРaaедактировать значение.", tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @PostMapping("/aaaaaa3", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity2(
        @RequestBody editData: DictTopicNodeEntityRestEdit
    ) = editData

    @Operation(summary = "aaaaРaaедактировать значение.", tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @PostMapping("/aaaaaa4", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity3(
        @RequestBody editData: DictTopicParamsByStandEntityRestEdit
    ) = editData

}