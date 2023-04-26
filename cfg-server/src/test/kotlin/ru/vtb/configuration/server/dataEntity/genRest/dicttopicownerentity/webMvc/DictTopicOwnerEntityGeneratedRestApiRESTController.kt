package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictTopicOwnerEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicOwnerEntity,
            DictTopicOwnerEntityImmutable,
            DictTopicOwnerEntityUpdateble,
            String,
            DictTopicOwnerEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicOwnerEntityGeneratedRepository

    override val filterDto: DictTopicOwnerEntityFilter
        get() = DictTopicOwnerEntityFilter.nullConst

    override fun restEditEntityDto(): IRestEditEntityDto<String, IUpdatebleEntity<DictTopicOwnerEntity>> = DictTopicOwnerEntityRestEdit(pk, hibernateEntityUpdateble())

    override fun getMockedRepo() = repository

    override val pk: String
        get() = "asdasd"

    override fun hibernateEntityUpdateble(): DictTopicOwnerEntityUpdateble = hibernateEntityImmutable.toUpdateble()

    override val hibernateEntityImmutable: DictTopicOwnerEntityImmutable
        get() = DictTopicOwnerEntityImmutable("asdasd", 1, "sd")
}

