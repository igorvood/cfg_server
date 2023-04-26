package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictServiceEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictServiceEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictServiceEntity,
            DictServiceEntityImmutable,
            DictServiceEntityUpdateble,
            String,
            DictServiceEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictServiceEntityGeneratedRepository

    override val filterDto: DictServiceEntityFilter
        get() = DictServiceEntityFilter.nullConst

    override fun restEditEntityDto(): IRestEditEntityDto<String, IUpdatebleEntity<DictServiceEntity>> = DictServiceEntityRestEdit(pk, hibernateEntityUpdateble())

    override fun hibernateEntityUpdateble(): DictServiceEntityUpdateble = hibernateEntityImmutable.toUpdateble()

    override val hibernateEntityImmutable: DictServiceEntityImmutable
        get() = DictServiceEntityImmutable("sad", "sad")
    override val pk: String
        get() = "serviceId"

    override fun getMockedRepo() = repository
}