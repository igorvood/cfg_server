package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictTopicParamsByStandEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicParamsByStandEntity,
            DictTopicParamsByStandEntityImmutable,
            DictTopicParamsByStandEntityUpdateble,
            DictTopicParamsByStandEntityPK,
            DictTopicParamsByStandEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicParamsByStandEntityGeneratedRepository

    override val filterDto: DictTopicParamsByStandEntityFilter
        get() = DictTopicParamsByStandEntityFilter.nullConst

    override fun restEditEntityDto(): IRestEditEntityDto<DictTopicParamsByStandEntityPK, IUpdatebleEntity<DictTopicParamsByStandEntity>> = DictTopicParamsByStandEntityRestEdit(pk, hibernateEntityUpdateble())

    override fun hibernateEntityUpdateble(): DictTopicParamsByStandEntityUpdateble = hibernateEntityImmutable.toUpdateble()

    override val hibernateEntityImmutable: DictTopicParamsByStandEntityImmutable
        get() = DictTopicParamsByStandEntityImmutable("sad", "sad", 1, "ASd")
    override val pk: DictTopicParamsByStandEntityPK
        get() = DictTopicParamsByStandEntityPK().apply {
            nodeId = "sad"
            standId = "sad"
        }

    override fun getMockedRepo() = repository
}