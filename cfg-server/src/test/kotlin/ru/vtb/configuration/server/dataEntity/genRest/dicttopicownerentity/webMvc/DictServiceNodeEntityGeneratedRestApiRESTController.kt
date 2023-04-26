package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictServiceNodeEntity
import ru.vtb.configuration.server.dataEntity.DictServiceNodeEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictServiceNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictServiceNodeEntity,
            DictServiceNodeEntityImmutable,
            DictServiceNodeEntityPK,
            DictServiceNodeEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictServiceNodeEntityGeneratedRepository

    override val filterDto: DictServiceNodeEntityFilter
        get() = DictServiceNodeEntityFilter.nullConst

    override val hibernateEntityImmutable: DictServiceNodeEntityImmutable
        get() = DictServiceNodeEntityImmutable("sad", "sad", "sad", "Asd", "asdasd")
    override val pk: DictServiceNodeEntityPK
        get() = DictServiceNodeEntityPK().apply {
            serviceId = "serviceId"
            profileId = "profileId"
        }

    override fun getMockedRepo() = repository
}