package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.reactive.genRest.dicttopicownerentity.*
import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import java.util.*

@RestController
@RequestMapping(path = arrayOf("/DictTopicOwnerEntity"))
class DictTopicOwnerEntityGeneratedRestApi(
    private val DictTopicOwnerEntityGeneratedRepository: R2dbcRepository<DictTopicOwnerEntity, String>,
//    private val orIsNullRepository: OrIsNullRepository<DictTopicOwnerEntityFilter, DictTopicOwnerEntity>

)//: IRestHibernateEntity<DictTopicOwnerEntityImmutable, String, DictTopicOwnerEntityFilter>
{

    @Operation(
        summary = "Найти по идентификатору.",
        tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PutMapping("/findById", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@RequestBody id: PrimaryKeyWrapper<String>) =
        DictTopicOwnerEntityGeneratedRepository.findById(id.primaryKey).map { it.toImmutable() }


    @Operation(summary = "Найти все.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @GetMapping("/findAll", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll() = DictTopicOwnerEntityGeneratedRepository.findAll().map { it.toImmutable() }

    @Operation(summary = "Сохранить.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
    @PutMapping("/save", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun save(@RequestBody data: DictTopicOwnerEntityImmutable) =
        DictTopicOwnerEntityGeneratedRepository.save(data.toMutable()).map { it.toImmutable() }

    @Operation(
        summary = "Удалить по идентификатору.",
        tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @DeleteMapping("/deleteById", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteById(@RequestBody id: PrimaryKeyWrapper<String>) =
        DictTopicOwnerEntityGeneratedRepository.deleteById(id.primaryKey)

//    @Operation(summary = "Выбобрка с фильтром.", tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"])
//    @PutMapping("/findByFilterOrIsNull", produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun findByFilterOrIsNull(filter: DictTopicOwnerEntityFilter): List<DictTopicOwnerEntityImmutable> = orIsNullRepository.findByFilterOrIsNull(filter).map { it.toImmutable() }

    @Operation(
        summary = "Редактировать значение.",
        tags = ["Генерированное API. Владелец топика(DictTopicOwnerEntity)"]
    )
    @PutMapping("/editEntity", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity(
        @RequestBody editData: DictTopicOwnerEntityRestEdit
    ) = DictTopicOwnerEntityGeneratedRepository
        .findById(editData.primaryKey)
        .flatMap { oldData ->
            DictTopicOwnerEntityGeneratedRepository.save(
                oldData.apply {
                    this@apply.id = editData.newData.id
                    this@apply.our = editData.newData.our
                    this@apply.descriptionForReport = editData.newData.descriptionForReport
                })
                .map { it.toImmutable() }
        }


}