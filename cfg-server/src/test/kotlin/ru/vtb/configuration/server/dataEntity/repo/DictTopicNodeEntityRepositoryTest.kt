package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.dataEntity.DictTopicParamsByStandEntity

internal class DictTopicNodeEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicNodeEntityRepository: DictTopicNodeEntityRepository


    @Test
    fun findById() {
        withTransactional {
            val findById = dictTopicNodeEntityRepository.findById("dev_input_withdraw_tx_dlq")

            assert(findById.isPresent)

            println(findById)

            val get = findById.get()

            get.dictTopicOwnerByTopicOwnerId.descriptionForReport = "asdasdasdas"
            get.dictTopicParamsByStandsById.add(DictTopicParamsByStandEntity())
            dictTopicNodeEntityRepository.save(get)
        }
        println(1)
//        withTransactional {
//            val findById = dictTopicParamsByStandEntityRepository.findById("qwerty").get()
//            findById.isOur = BigInteger.valueOf(0)
//            val save = dictTopicOwnerEntityRepository.save(findById)
//        }
    }


}