package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntityReactive
//import ru.vtb.configuration.server.dataEntity.reactive.genRest.dicttopicownerentity.DictTopicOwnerEntityImmutable
//import ru.vtb.configuration.server.dataEntity.reactive.genRest.dicttopicownerentity.DictTopicOwnerEntityRestEdit


import ru.vtb.processor.wrapper.PrimaryKeyWrapper

//fun DictTopicOwnerEntity.toImmutable() : DictTopicOwnerEntityImmutable =  DictTopicOwnerEntityImmutable(this.id,this.our,this.descriptionForReport)
@RestController
@RequestMapping(path = ["/DictTopicOwnerEntity"])
class DictTopicOwnerEntityGeneratedRestApi(
    private val DictTopicOwnerEntityGeneratedRepository: CoroutineCrudRepository<DictTopicOwnerEntityReactive, String>,
//    private val orIsNullRepository: OrIsNullRepository<DictTopicOwnerEntityFilter, DictTopicOwnerEntity>

)//: IRestHibernateEntity<DictTopicOwnerEntityImmutable, String, DictTopicOwnerEntityFilter>
{
    private val log: Logger = LoggerFactory.getLogger(DictTopicOwnerEntityGeneratedRestApi::class.java)
    @Operation(
        summary = "Найти по идентификатору.",
        tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PutMapping("/findById", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun findById(@RequestBody id: PrimaryKeyWrapper<String>) =
        DictTopicOwnerEntityGeneratedRepository.findById(id.primaryKey)

    @PutMapping("/findByIdNoWrapperBlocking", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findByIdNoWrapperBlocking(@RequestParam id: String): DictTopicOwnerEntityReactive? {
        log.info("findByIdNoWrapperBlocking")
        val findById = runBlocking { DictTopicOwnerEntityGeneratedRepository.findById(id)}
        val toImmutable = findById
        return toImmutable
    }

    @PutMapping("/findByIdNoWrapperNonBlocking", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun findByIdNoWrapperNonBlocking(@RequestParam id: String): DictTopicOwnerEntityReactive? {
        val findById =  DictTopicOwnerEntityGeneratedRepository.findById(id)
        log.info("findByIdNoWrapperNonBlocking_1111")
        delay(2000)
        log.info("findByIdNoWrapperNonBlocking_22222")
        val toImmutable = findById
        return toImmutable
    }


    @Operation(summary = "Найти все.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @GetMapping("/findAll", produces = [MediaType.APPLICATION_JSON_VALUE])
    suspend fun findAll(): Flow<DictTopicOwnerEntityReactive> {
        val findAll = DictTopicOwnerEntityGeneratedRepository.findAll()
        val map = findAll
        return map
    }

    @Operation(summary = "Сохранить.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @PutMapping("/save", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    suspend fun save(@RequestBody data: DictTopicOwnerEntityReactive) =
        DictTopicOwnerEntityGeneratedRepository.save(data)

    @Operation(
        summary = "Удалить по идентификатору.",
        tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @DeleteMapping("/deleteById", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    suspend fun deleteById(@RequestBody id: PrimaryKeyWrapper<String>) =
        DictTopicOwnerEntityGeneratedRepository.deleteById(id.primaryKey)

//    @Operation(
//        summary = "Редактировать значение.",
//        tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"]
//    )
//    @PutMapping("/editEntity", produces = [MediaType.APPLICATION_JSON_VALUE])
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    suspend fun editEntity(
//        @RequestBody editData: DictTopicOwnerEntityRestEdit
//    ): DictTopicOwnerEntityImmutable? {
//        val findById = DictTopicOwnerEntityGeneratedRepository
//            .findById(editData.primaryKey)
//        val let: DictTopicOwnerEntityImmutable? = findById?.let { oldData ->
//            DictTopicOwnerEntityGeneratedRepository.save(
//                oldData.apply {
//                    this@apply.id = editData.newData.id
//                    this@apply.our = editData.newData.our
//                    this@apply.descriptionForReport = editData.newData.descriptionForReport
//                }).toImmutable()
//        }
//        return let
//    }


}