package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityRestEdit

class DictTopicParamsByStandEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicParamsByStandEntity,
            DictTopicParamsByStandEntityImmutable,
            DictTopicParamsByStandEntityPK,
            DictTopicParamsByStandEntityGeneratedRepository,
            DictTopicParamsByStandEntityRestEdit,
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicParamsByStandEntityGeneratedRepository

    override fun restEditEntityDto(): DictTopicParamsByStandEntityRestEdit = DictTopicParamsByStandEntityRestEdit(pk, hibernateEntityImmutable)

    override val hibernateEntityImmutable: DictTopicParamsByStandEntityImmutable
        get() = DictTopicParamsByStandEntityImmutable("sad", "sad", 1, "ASd")
    override val pk: DictTopicParamsByStandEntityPK
        get() = DictTopicParamsByStandEntityPK().apply {
            nodeId = "sad"
            standId = "sad"
        }

    override fun getMockedRepo(): DictTopicParamsByStandEntityGeneratedRepository = repository
}