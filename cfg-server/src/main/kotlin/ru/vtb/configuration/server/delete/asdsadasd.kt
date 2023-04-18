package ru.vtb.configuration.server.delete

import io.swagger.v3.oas.annotations.Operation

import org.springframework.http.MediaType
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityRestEdit


@RestController
@RequestMapping(path = ["/AAAAAAA"])

class asdsadasd {



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