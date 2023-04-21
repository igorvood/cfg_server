package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.*
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dictservicegroupentity.DictServiceGroupEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictservicegroupentity.DictServiceGroupEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictservicegroupentity.DictServiceGroupEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictservicegroupentity.DictServiceGroupEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityRestEdit

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

    override fun restEditEntityDto(): DictServiceGroupEntityRestEdit = DictServiceGroupEntityRestEdit(pk, hibernateEntityImmutable)
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