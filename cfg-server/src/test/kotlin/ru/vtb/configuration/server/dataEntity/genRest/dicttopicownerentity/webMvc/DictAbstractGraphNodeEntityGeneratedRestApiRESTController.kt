package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit

class DictAbstractGraphNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictAbstractGraphNodeEntity,
            DictAbstractGraphNodeEntityImmutable,
            DictAbstractGraphNodeEntityPK,
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictAbstractGraphNodeEntityGeneratedRepository

    override fun restEditEntityDto(): DictAbstractGraphNodeEntityRestEdit = DictAbstractGraphNodeEntityRestEdit(pk, hibernateEntityImmutable)
    override val hibernateEntityImmutable: DictAbstractGraphNodeEntityImmutable
        get() = DictAbstractGraphNodeEntityImmutable("sad", "sad", "sad")
    override val pk: DictAbstractGraphNodeEntityPK
        get() = DictAbstractGraphNodeEntityPK().apply {
            graphId = "sad"
            nodeType = "sad"
            nodeId = "sad"
        }

    override fun getMockedRepo(): DictAbstractGraphNodeEntityGeneratedRepository = repository
}