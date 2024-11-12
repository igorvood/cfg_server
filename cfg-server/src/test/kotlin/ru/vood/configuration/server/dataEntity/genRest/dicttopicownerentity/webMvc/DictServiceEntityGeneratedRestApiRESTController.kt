package ru.vood.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vood.configuration.server.dataEntity.DictServiceEntity
import ru.vood.configuration.server.dataEntity.genRest.dictserviceentity.*
import ru.vood.processor.intf.IUpdatebleEntity
import ru.vood.processor.wrapper.IRestEditEntityDto

class DictServiceEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictServiceEntity,
            DictServiceEntityImmutable,
            String,
            DictServiceEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictServiceEntityGeneratedRepository

    override val filterDto: DictServiceEntityFilter
        get() = DictServiceEntityFilter.nullConst

    override val hibernateEntityImmutable: DictServiceEntityImmutable
        get() = DictServiceEntityImmutable("sad", "sad")
    override val pk: String
        get() = "serviceId"

    override fun getMockedRepo() = repository
}