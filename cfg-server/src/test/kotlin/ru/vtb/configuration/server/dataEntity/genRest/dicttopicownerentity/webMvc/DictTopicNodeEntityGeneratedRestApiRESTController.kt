package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.webMvc

import com.ninjasquad.springmockk.MockkBean
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityRestEdit
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityImmutable
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicnodeentity.DictTopicNodeEntityRestEdit

class DictTopicNodeEntityGeneratedRestApiRESTController :
    AbstractEntityGeneratedRestApiRESTController<
            DictTopicNodeEntity,
            DictTopicNodeEntityImmutable,
            String,
            DictTopicNodeEntityGeneratedRepository,
            DictTopicNodeEntityRestEdit,
            >() {

    @MockkBean(relaxed = true)
    lateinit var repository: DictTopicNodeEntityGeneratedRepository

    override fun restEditEntityDto(): DictTopicNodeEntityRestEdit = DictTopicNodeEntityRestEdit(pk, hibernateEntityImmutable)

    override val hibernateEntityImmutable: DictTopicNodeEntityImmutable
        get() = DictTopicNodeEntityImmutable("sad", "sad", "sad", "ASd", 1)
    override val pk: String
        get() = "sad"

    override fun getMockedRepo(): DictTopicNodeEntityGeneratedRepository = repository
}

//{"primaryKeyWrapper":{"primaryKey":{"graphId":"sad","nodeType":"sad","nodeId":"sad"}},"newData":{"graphId":"sad","nodeType":"sad","nodeId":"sad"}}
//{"primaryKeyWrapper":{"primaryKey": "string"
//  },
//  "newData": {
//    "id": "string",
//    "our": 0,
//    "descriptionForReport": "string"
//  }
//}