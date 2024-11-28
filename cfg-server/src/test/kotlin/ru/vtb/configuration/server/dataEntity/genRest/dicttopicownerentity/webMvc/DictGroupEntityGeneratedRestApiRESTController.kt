package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictGroupEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictgroupentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictGroupEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictGroupEntity,
            DictGroupEntityImmutable,
            String,
            DictGroupEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictGroupEntityGeneratedRepository

    override val filterDto: DictGroupEntityFilter
        get() = DictGroupEntityFilter.nullConst

    override val hibernateEntityImmutable: DictGroupEntityImmutable
        get() = DictGroupEntityImmutable("sad", "sad")

    override val pk: String
        get() = "asd"

    override fun getMockedRepo() = repository
}