package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictArrowEntity
import ru.vtb.configuration.server.dataEntity.DictArrowEntityPK
import ru.vtb.configuration.server.dataEntity.DictServiceEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictarrowentity.DictArrowEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictarrowentity.DictArrowEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictarrowentity.DictArrowEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictarrowentity.DictArrowEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityRestEdit

class DictArrowEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictArrowEntity,
            DictArrowEntityImmutable,
            DictArrowEntityPK,
            DictArrowEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictArrowEntityGeneratedRepository

    override val filterDto: DictArrowEntityFilter
        get() = DictArrowEntityFilter.nullConst

    override fun restEditEntityDto(): DictArrowEntityRestEdit = DictArrowEntityRestEdit(pk, hibernateEntityImmutable)
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

    override fun getMockedRepo(): DictArrowEntityGeneratedRepository = repository
}