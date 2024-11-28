package ru.vtb.configuration.server.delete

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityRestEdit


fun DictTopicParamsByStandEntity.toImmutable(): DictTopicParamsByStandEntityImmutable =
    DictTopicParamsByStandEntityImmutable(this.nodeId, this.standId, this.cntPartition, this.topicName)

@RestController
@RequestMapping(path = ["/AAAAAAA"])
@Deprecated("")
class asdsadasd(val dictTopicParamsByStandEntityGeneratedRepository: DictTopicParamsByStandEntityGeneratedRepository) {

    @Operation(
        summary = "Редактировать значение.",
        tags = ["TEST"]
    )
    @PutMapping("/editEntity11", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity(
        @RequestBody editData: DictTopicParamsByStandEntityRestEdit
    ): DictTopicParamsByStandEntityImmutable? {
//        val primaryKey = editData.primaryKey
//        val create = Example.create(primaryKey)
//        TypedExample<DictTopicParamsByStandEntityPK>(primaryKey,)
        println(1)

        val findById = dictTopicParamsByStandEntityGeneratedRepository.findById(editData.primaryKey)

        val map: DictTopicParamsByStandEntityImmutable? = findById.map { oldData ->
            dictTopicParamsByStandEntityGeneratedRepository.save(
                oldData.apply {
                    this@apply.nodeId = editData.newData.nodeId
                    this@apply.standId = editData.newData.standId
                    this@apply.cntPartition = editData.newData.cntPartition
                    this@apply.topicName = editData.newData.topicName
                }).toImmutable()
        }.orElseGet { null }

        return map
    }

    @Operation(
        summary = "aaaaРaaедактировать значение.",
        tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PostMapping("/aaaaaa1", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity(
        @RequestBody editData: DictTopicOwnerEntityRestEdit
    ) = editData

    @Operation(
        summary = "aaaaРaaедактировать значение.",
        tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PostMapping("/aaaaaa2", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity1(
        @RequestBody editData: DictAbstractGraphNodeEntityRestEdit
    ) = editData


    @Operation(
        summary = "aaaaРaaедактировать значение.",
        tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PostMapping("/aaaaaa3", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity2(
        @RequestBody editData: DictTopicNodeEntityRestEdit
    ) = editData

    @Operation(
        summary = "aaaaРaaедактировать значение.",
        tags = ["aaaaaГенерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PostMapping("/aaaaaa4", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity3(
        @RequestBody editData: DictTopicParamsByStandEntityRestEdit
    ) = editData

}