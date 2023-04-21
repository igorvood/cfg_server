package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityRestEdit

class DictTopicNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicNodeEntity,
            DictTopicNodeEntityImmutable,
            String,
            DictTopicNodeEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicNodeEntityGeneratedRepository

    override val filterDto: DictTopicNodeEntityFilter
        get() = DictTopicNodeEntityFilter.nullConst

    override fun restEditEntityDto(): DictTopicNodeEntityRestEdit = DictTopicNodeEntityRestEdit(pk, hibernateEntityImmutable)

    override val hibernateEntityImmutable: DictTopicNodeEntityImmutable
        get() = DictTopicNodeEntityImmutable("sad", "sad", "sad", "ASd", 1)
    override val pk: String
        get() = "sad"

    override fun getMockedRepo() = repository
}

