package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityGeneratedRepository
//import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.toImmutable
import kotlin.test.assertEquals


internal class DictTopicOwnerEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicOwnerEntityRepository: DictTopicOwnerEntityGeneratedRepository


    @Test
    fun findById() {
        withTransactional {
            val findById = dictTopicOwnerEntityRepository.findById("qwerty").get()
            findById.our = 0
            val save = dictTopicOwnerEntityRepository.save(findById)
        }
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Rollback(false)
    fun save() {
        val apply = DictTopicOwnerEntity().apply {
            id = "id1"
            our = 1
            descriptionForReport = "id1"
        }
        val save = dictTopicOwnerEntityRepository.save(apply)

        val findById = dictTopicOwnerEntityRepository.findById("id1")

        assertEquals(apply, findById.get())
    }

//    @Test
//    @Transactional
//    @Rollback(false)
//    @Ignore
//    fun update() {
//        val id = "qwerty"
////        val id = "DKO_COMMAND"
//
//        val findById = dictTopicOwnerEntityRepository.findById(id)
//        val orElseGet = findById
//            .map {
//                it.id = id + "asd"
//                dictTopicOwnerEntityRepository.save(it).toImmutable()
////                    id, id + "asd"
////            ,DictTopicOwnerEntity("asd",BigInteger.ZERO,"asd")
////                )
//            }.orElseGet(throw java.lang.IllegalArgumentException("asdsada"))
//
//        val orElseGet1 =
//            findById.map { it.toImmutable() }.orElseGet(throw java.lang.IllegalArgumentException("asdsada"))
//
//
//        assertEquals(orElseGet1, orElseGet)
//
//    }


}