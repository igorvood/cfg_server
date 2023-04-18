package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityRestEdit

class DictTopicOwnerEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicOwnerEntity,
            DictTopicOwnerEntityImmutable,
            String,
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicOwnerEntityGeneratedRepository
    override fun restEditEntityDto(): DictTopicOwnerEntityRestEdit = DictTopicOwnerEntityRestEdit(pk, hibernateEntityImmutable)

    override fun getMockedRepo(): DictTopicOwnerEntityGeneratedRepository = repository

    override val pk: String
        get() = "asdasd"
    override val hibernateEntityImmutable: DictTopicOwnerEntityImmutable
        get() = DictTopicOwnerEntityImmutable("asdasd", 1, "sd")
}

