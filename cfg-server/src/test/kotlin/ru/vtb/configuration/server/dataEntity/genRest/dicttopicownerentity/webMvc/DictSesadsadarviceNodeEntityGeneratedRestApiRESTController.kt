package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.*
import ru.vtb.configuration.server.dataEntity.genRest.dictservicegroupentity.*
import ru.vtb.processor.intf.IUpdatebleEntity
import ru.vtb.processor.wrapper.IRestEditEntityDto

class DictSesadsadarviceNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictServiceGroupEntity,
            DictServiceGroupEntityImmutable,
            DictServiceGroupEntityPK,
            DictServiceGroupEntityFilter
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictServiceGroupEntityGeneratedRepository

    override val filterDto: DictServiceGroupEntityFilter
        get() = DictServiceGroupEntityFilter.nullConst


    override val hibernateEntityImmutable: DictServiceGroupEntityImmutable
        get() = DictServiceGroupEntityImmutable("sad", "sad", "sad")
    override val pk: DictServiceGroupEntityPK
        get() = DictServiceGroupEntityPK().apply {
            groupId = "groupId"
            serviceId = "serviceId"
            profileId = "profileId"

        }

    override fun getMockedRepo() = repository
}