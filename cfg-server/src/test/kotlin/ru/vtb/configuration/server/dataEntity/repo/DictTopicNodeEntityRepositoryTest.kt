package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity
import ru.vtb.configuration.server.dataEntity.genRest.DictTopicNodeEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.DictTopicParamsByStandEntityGeneratedRepository
import java.math.BigInteger

internal class DictTopicNodeEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicNodeEntityRepository: DictTopicNodeEntityGeneratedRepository

    @Autowired
    lateinit var dictTopicParamsByStandEntityGeneratedRepository: DictTopicParamsByStandEntityGeneratedRepository

    @Test
    fun findById() {
        withTransactional {
            val findById = dictTopicNodeEntityRepository.findById("APRF_STATIC_PUB")

            assert(findById.isPresent)

            println(findById)

            val dictTopicNodeEntity: DictTopicNodeEntity = findById.get()


//            dictTopicNodeEntity.dictTopicOwnerByTopicOwnerId.descriptionForReport = "asdasdasdas"
            dictTopicNodeEntity.retention=BigInteger.valueOf(19)
            val dictTopicParamsByStandEntity = DictTopicParamsByStandEntity().apply {
                nodeId = dictTopicNodeEntity.id
                standId = "DSO"
                cntPartition = BigInteger.valueOf(18)
                topicName = dictTopicNodeEntity.id
//                dictTopicNodeByNodeId = null
            }
//            dictTopicNodeEntity.dictTopicParamsByStandsById.add(dictTopicParamsByStandEntity)
            dictTopicNodeEntityRepository.save(dictTopicNodeEntity)

            dictTopicParamsByStandEntityGeneratedRepository.save(dictTopicParamsByStandEntity)
        }
        println(1)
//        withTransactional {
//            val findById = dictTopicParamsByStandEntityRepository.findById("qwerty").get()
//            findById.isOur = BigInteger.valueOf(0)
//            val save = dictTopicOwnerEntityRepository.save(findById)
//        }
    }


}