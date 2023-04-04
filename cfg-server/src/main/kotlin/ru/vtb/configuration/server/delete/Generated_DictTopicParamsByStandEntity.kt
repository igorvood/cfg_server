
package ru.vtb.configuration.server.delete

import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.dataEntity.genRest.DictTopicParamsByStandEntityImmutable

import ru.vtb.configuration.server.dataEntity.generated.DictTopicParamsByStandEntityGeneratedRepository

data class DictTopicParamsByStandEntityImmutable (
val nodeId : String,
val standId : String,
val cntPartition : java.math.BigInteger,
val topicName : String
)
fun DictTopicParamsByStandEntityImmutable.toMutable() = DictTopicParamsByStandEntity().apply {
this@apply.nodeId = this@toMutable.nodeId
this@apply.standId = this@toMutable.standId
this@apply.cntPartition = this@toMutable.cntPartition
this@apply.topicName = this@toMutable.topicName
  }

fun DictTopicParamsByStandEntity.toImmutable() : DictTopicParamsByStandEntityImmutable =  DictTopicParamsByStandEntityImmutable(this.nodeId,this.standId,this.cntPartition,this.topicName)



//@RestController
class DictTopicParamsByStandEntityGeneratedRestApi(
    val DictTopicParamsByStandEntityGeneratedRepository: DictTopicParamsByStandEntityGeneratedRepository
) {

    @Operation(summary = "DictTopicParamsByStandEntity findAll", tags = ["Генерированное API"])
    @GetMapping("/DictTopicParamsByStandEntity/findAll")
    fun findAll() = DictTopicParamsByStandEntityGeneratedRepository.findAll().map { it.toImmutable() }


    @Operation(summary = "DictTopicParamsByStandEntity save", tags = ["Генерированное API"])
    @PutMapping("/DictTopicParamsByStandEntity/save")
    fun save(data: DictTopicParamsByStandEntityImmutable) = DictTopicParamsByStandEntityGeneratedRepository.save(data.toMutable())




}
