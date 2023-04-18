package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityImmutable

class DictTopicParamsByStandEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<DictTopicParamsByStandEntity, DictTopicParamsByStandEntityImmutable, DictTopicParamsByStandEntityPK, DictTopicParamsByStandEntityGeneratedRepository>() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicParamsByStandEntityGeneratedRepository


    override val hibernateEntityImmutable: DictTopicParamsByStandEntityImmutable
        get() = DictTopicParamsByStandEntityImmutable("sad", "sad", 1, "ASd")
    override val pk: DictTopicParamsByStandEntityPK
        get() = DictTopicParamsByStandEntityPK().apply {
            nodeId = "sad"
            standId = "sad"
        }

    override fun getMockedRepo(): DictTopicParamsByStandEntityGeneratedRepository = repository
}