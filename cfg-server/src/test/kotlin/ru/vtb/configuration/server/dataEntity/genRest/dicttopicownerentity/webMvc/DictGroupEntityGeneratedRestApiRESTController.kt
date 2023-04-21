package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictGroupEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictgroupentity.DictGroupEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictgroupentity.DictGroupEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictgroupentity.DictGroupEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictgroupentity.DictGroupEntityRestEdit

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

    override fun restEditEntityDto(): DictGroupEntityRestEdit = DictGroupEntityRestEdit(pk, hibernateEntityImmutable)

    override val hibernateEntityImmutable: DictGroupEntityImmutable
        get() = DictGroupEntityImmutable("sad", "sad")

    override val pk: String
        get() = "asd"

    override fun getMockedRepo() = repository
}