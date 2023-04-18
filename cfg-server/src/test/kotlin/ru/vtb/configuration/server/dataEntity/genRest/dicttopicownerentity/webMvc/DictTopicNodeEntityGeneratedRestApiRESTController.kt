package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityImmutable

class DictTopicNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<DictTopicNodeEntity, DictTopicNodeEntityImmutable, String, DictTopicNodeEntityGeneratedRepository>() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicNodeEntityGeneratedRepository


    override val hibernateEntityImmutable: DictTopicNodeEntityImmutable
        get() = DictTopicNodeEntityImmutable("sad", "sad", "sad", "ASd", 1)
    override val pk: String
        get() = "sad"

    override fun getMockedRepo(): DictTopicNodeEntityGeneratedRepository = repository
}