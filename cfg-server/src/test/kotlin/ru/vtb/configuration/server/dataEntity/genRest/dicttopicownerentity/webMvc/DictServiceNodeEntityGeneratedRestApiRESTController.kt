package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.configuration.server.dataEntity.DictServiceNodeEntity
import ru.vtb.configuration.server.dataEntity.DictServiceNodeEntityPK
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dictservicenodeentity.DictServiceNodeEntityRestEdit

class DictServiceNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictServiceNodeEntity,
            DictServiceNodeEntityImmutable,
            DictServiceNodeEntityPK,
            DictServiceNodeEntityGeneratedRepository,

            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictServiceNodeEntityGeneratedRepository

    override fun restEditEntityDto(): DictServiceNodeEntityRestEdit = DictServiceNodeEntityRestEdit(pk, hibernateEntityImmutable)
    override val hibernateEntityImmutable: DictServiceNodeEntityImmutable
        get() = DictServiceNodeEntityImmutable("sad", "sad", "sad", "Asd", "asdasd")
    override val pk: DictServiceNodeEntityPK
        get() = DictServiceNodeEntityPK().apply {
            serviceId = "serviceId"
            profileId = "profileId"
        }

    override fun getMockedRepo(): DictServiceNodeEntityGeneratedRepository = repository
}