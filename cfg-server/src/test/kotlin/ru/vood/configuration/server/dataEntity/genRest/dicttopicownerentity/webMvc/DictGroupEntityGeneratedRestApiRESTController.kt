package ru.vood.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vood.configuration.server.dataEntity.DictGroupEntity
import ru.vood.configuration.server.dataEntity.genRest.dictgroupentity.*
import ru.vood.processor.intf.IUpdatebleEntity
import ru.vood.processor.wrapper.IRestEditEntityDto

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