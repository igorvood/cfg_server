package ru.vtb.configuration.server.delete


import io.swagger.v3.oas.annotations.Operation
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.DictTopicParamsByStandEntityGeneratedRepository

data class DictTopicParamsByStandEntityImmutable(
    val nodeId: String,
    val standId: String,
    val cntPartition: java.math.BigInteger,
    val topicName: String
)

fun DictTopicParamsByStandEntityImmutable.toMutable() = DictTopicParamsByStandEntity().apply {
    this@apply.nodeId = this@toMutable.nodeId
    this@apply.standId = this@toMutable.standId
    this@apply.cntPartition = this@toMutable.cntPartition
    this@apply.topicName = this@toMutable.topicName
}

fun DictTopicParamsByStandEntity.toImmutable(): DictTopicParamsByStandEntityImmutable =
    DictTopicParamsByStandEntityImmutable(this.nodeId, this.standId, this.cntPartition, this.topicName)


//@RestController
class DictTopicParamsByStandEntityGeneratedRestApi(
    val DictTopicParamsByStandEntityGeneratedRepository: DictTopicParamsByStandEntityGeneratedRepository
) {

    @Operation(summary = "DictTopicParamsByStandEntity findAll", tags = ["Генерированное API"])
    @GetMapping("/DictTopicParamsByStandEntity/findAll")
    fun findAll() = DictTopicParamsByStandEntityGeneratedRepository.findAll().map { it.toImmutable() }


    @Operation(summary = "DictTopicParamsByStandEntity save", tags = ["Генерированное API"])
    @PutMapping("/DictTopicParamsByStandEntity/save")
    fun save(data: DictTopicParamsByStandEntityImmutable) =
        DictTopicParamsByStandEntityGeneratedRepository.save(data.toMutable())


    @Operation(summary = "DictTopicParamsByStandEntity deleteById", tags = ["Генерированное API"])
    @DeleteMapping("/DictTopicParamsByStandEntity/deleteById")
    fun deleteById(data: DictTopicParamsByStandEntityPK) =
        DictTopicParamsByStandEntityGeneratedRepository.deleteById(data)


    @Operation(summary = "DictTopicParamsByStandEntity editEntity", tags = ["Генерированное API"])
    @PostMapping("/DictTopicParamsByStandEntity/editEntity")
    fun editEntity(
        data: DictTopicParamsByStandEntityPK,
        newData: DictTopicParamsByStandEntityImmutable
    ) = DictTopicParamsByStandEntityGeneratedRepository.findByIdOrNull(data)?.let { oldData ->
        DictTopicParamsByStandEntityGeneratedRepository.save(
            oldData.apply {
                this@apply.standId = newData.standId
            }).toImmutable()
    }


}
