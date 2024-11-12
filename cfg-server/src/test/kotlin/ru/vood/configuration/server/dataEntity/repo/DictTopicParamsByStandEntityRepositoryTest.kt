package ru.vood.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.configuration.server.abstraction.AbstractDatasourceTests
import ru.vood.configuration.server.dataEntity.genRest.dicttopicparamsbystandentity.DictTopicParamsByStandEntityGeneratedRepository
import java.math.BigInteger

internal class DictTopicParamsByStandEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicParamsByStandEntityRepository: DictTopicParamsByStandEntityGeneratedRepository


    @Test
    fun findById() {
//        withTransactional {
//            val findById = dictTopicParamsByStandEntityRepository.findById("qwerty").get()
//            findById.isOur = BigInteger.valueOf(0)
//            val save = dictTopicOwnerEntityRepository.save(findById)
//        }
    }


}