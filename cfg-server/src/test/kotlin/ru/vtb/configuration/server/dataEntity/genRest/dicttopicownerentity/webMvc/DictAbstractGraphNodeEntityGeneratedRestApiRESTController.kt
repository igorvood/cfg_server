package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityImmutable
import ru.vtb.processor.wrapper.PrimaryKeyWrapper

class DictAbstractGraphNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<DictAbstractGraphNodeEntity, DictAbstractGraphNodeEntityImmutable, DictAbstractGraphNodeEntityPK, DictAbstractGraphNodeEntityGeneratedRepository>() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictAbstractGraphNodeEntityGeneratedRepository


    override val hibernateEntityImmutable: DictAbstractGraphNodeEntityImmutable
        get() = DictAbstractGraphNodeEntityImmutable("sad", "sad", "sad")
    override val pk: PrimaryKeyWrapper<DictAbstractGraphNodeEntityPK>
        get() {
            val apply = DictAbstractGraphNodeEntityPK().apply {
                graphId = "sad"
                nodeType = "sad"
                nodeId = "sad"
            }
            return PrimaryKeyWrapper(apply)
        }

    override fun getMockedRepo(): DictAbstractGraphNodeEntityGeneratedRepository = repository
}