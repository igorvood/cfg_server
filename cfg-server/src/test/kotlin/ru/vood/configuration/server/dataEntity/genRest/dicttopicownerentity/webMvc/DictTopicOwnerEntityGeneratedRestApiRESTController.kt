package ru.vood.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vood.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vood.configuration.server.dataEntity.genRest.dicttopicownerentity.*
import ru.vood.processor.intf.IUpdatebleEntity
import ru.vood.processor.wrapper.IRestEditEntityDto

class DictTopicOwnerEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicOwnerEntity,
            DictTopicOwnerEntityImmutable,
            String,
            DictTopicOwnerEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicOwnerEntityGeneratedRepository

    override val filterDto: DictTopicOwnerEntityFilter
        get() = DictTopicOwnerEntityFilter.nullConst

    override fun getMockedRepo() = repository

    override val pk: String
        get() = "asdasd"

    override val hibernateEntityImmutable: DictTopicOwnerEntityImmutable
        get() = DictTopicOwnerEntityImmutable("asdasd", 1, "sd")
}

