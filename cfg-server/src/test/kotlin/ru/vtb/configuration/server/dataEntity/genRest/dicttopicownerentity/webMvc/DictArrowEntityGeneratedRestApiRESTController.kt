package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictArrowEntity
import ru.vtb.configuration.server.dataEntity.DictArrowEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictarrowentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictArrowEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictArrowEntity,
            DictArrowEntityImmutable,
            DictArrowEntityUpdateble,
            DictArrowEntityPK,
            DictArrowEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictArrowEntityGeneratedRepository

    override val filterDto: DictArrowEntityFilter
        get() = DictArrowEntityFilter.nullConst

    override fun restEditEntityDto(): IRestEditEntityDto<DictArrowEntityPK, IUpdatebleEntity<DictArrowEntity>> = DictArrowEntityRestEdit(pk, hibernateEntityUpdateble())

    override fun hibernateEntityUpdateble(): DictArrowEntityUpdateble = hibernateEntityImmutable.toUpdateble()

    override val hibernateEntityImmutable: DictArrowEntityImmutable
        get() = DictArrowEntityImmutable("graphId", "begNodeType", "begNodeId", "endNodeType", "endNodeId", "propKey", "asdsa", "asdasas", "asdsadas", "asdasdasd")
    override val pk: DictArrowEntityPK
        get() = DictArrowEntityPK().apply {
            graphId = "graphId"
            begNodeType = "begNodeType"
            begNodeId = "begNodeId"
            endNodeType = "endNodeType"
            endNodeId = "endNodeId"
        }

    override fun getMockedRepo() = repository
}