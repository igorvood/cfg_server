package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityImmutable
import ru.vtb.processor.wrapper.PrimaryKeyWrapper

class DictTopicOwnerEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<DictTopicOwnerEntity, DictTopicOwnerEntityImmutable, String, DictTopicOwnerEntityGeneratedRepository>() {

    @MockkBean(relaxed = true)
    lateinit var repository:  DictTopicOwnerEntityGeneratedRepository

    override fun getMockedRepo(): DictTopicOwnerEntityGeneratedRepository = repository

    override val pk: String
        get() = "asdasd"
    override val hibernateEntityImmutable: DictTopicOwnerEntityImmutable
        get() = DictTopicOwnerEntityImmutable("asdasd", 1, "sd")
}

