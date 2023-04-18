package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictServiceEntity
import ru.vtb.configuration.server.dataEntity.DictServiceNodeEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictserviceentity.DictServiceEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityRestEdit

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

    override fun restEditEntityDto(): DictServiceEntityRestEdit = DictServiceEntityRestEdit(pk, hibernateEntityImmutable)
    override val hibernateEntityImmutable: DictServiceEntityImmutable
        get() = DictServiceEntityImmutable("sad", "sad")
    override val pk: String
        get() = "serviceId"

    override fun getMockedRepo(): DictServiceEntityGeneratedRepository = repository
}