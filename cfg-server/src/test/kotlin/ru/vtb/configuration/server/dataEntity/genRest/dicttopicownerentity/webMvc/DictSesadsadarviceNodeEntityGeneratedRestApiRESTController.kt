package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vood.configuration.server.dataEntity.DictServiceGroupEntity
import ru.vood.configuration.server.dataEntity.DictServiceGroupEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictservicegroupentity.*

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