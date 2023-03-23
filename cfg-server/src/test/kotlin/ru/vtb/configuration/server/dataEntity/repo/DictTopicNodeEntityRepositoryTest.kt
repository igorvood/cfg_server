package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests

internal class DictTopicNodeEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicNodeEntityRepository: DictTopicNodeEntityRepository


    @Test
    fun findById() {
//        withTransactional {
//            val findById = dictTopicParamsByStandEntityRepository.findById("qwerty").get()
//            findById.isOur = BigInteger.valueOf(0)
//            val save = dictTopicOwnerEntityRepository.save(findById)
//        }
    }


}