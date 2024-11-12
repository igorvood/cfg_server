package ru.vood.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vood.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vood.configuration.server.dataEntity.DictTopicParamsByStandEntityPK
import ru.vood.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.*
import ru.vood.processor.intf.IUpdatebleEntity
import ru.vood.processor.wrapper.IRestEditEntityDto

class DictTopicParamsByStandEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicParamsByStandEntity,
            DictTopicParamsByStandEntityImmutable,
            DictTopicParamsByStandEntityPK,
            DictTopicParamsByStandEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicParamsByStandEntityGeneratedRepository

    override val filterDto: DictTopicParamsByStandEntityFilter
        get() = DictTopicParamsByStandEntityFilter.nullConst

    override val hibernateEntityImmutable: DictTopicParamsByStandEntityImmutable
        get() = DictTopicParamsByStandEntityImmutable("sad", "sad", 1, "ASd")
    override val pk: DictTopicParamsByStandEntityPK
        get() = DictTopicParamsByStandEntityPK().apply {
            nodeId = "sad"
            standId = "sad"
        }

    override fun getMockedRepo() = repository
}