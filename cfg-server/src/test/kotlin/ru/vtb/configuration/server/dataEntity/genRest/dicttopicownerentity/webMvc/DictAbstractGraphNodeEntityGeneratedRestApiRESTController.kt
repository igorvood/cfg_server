package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictAbstractGraphNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictAbstractGraphNodeEntity,
            DictAbstractGraphNodeEntityImmutable,
            DictAbstractGraphNodeEntityPK,
            DictAbstractGraphNodeEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictAbstractGraphNodeEntityGeneratedRepository

    override val filterDto: DictAbstractGraphNodeEntityFilter
        get() = DictAbstractGraphNodeEntityFilter.nullConst

    override val hibernateEntityImmutable: DictAbstractGraphNodeEntityImmutable
        get() = DictAbstractGraphNodeEntityImmutable("sad", "sad", "sad")

    override val pk: DictAbstractGraphNodeEntityPK
        get() = DictAbstractGraphNodeEntityPK().apply {
            graphId = "sad"
            nodeType = "sad"
            nodeId = "sad"
        }

    override fun getMockedRepo() = repository
}