package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityFilter
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityGeneratedRepository
import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.DictTopicOwnerEntityOrIsNullRepository
import ru.vtb.processor.intf.OrIsNullRepository
//import ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity.toImmutable
import kotlin.test.assertEquals


internal class DictTopicOwnerEntityRepositoryTestNew : AbstractRepositoryTest<DictTopicOwnerEntity, String, DictTopicOwnerEntityFilter>() {


    @Autowired
    lateinit var dictTopicOwnerEntityRepository: DictTopicOwnerEntityGeneratedRepository

    @Autowired
    lateinit var orIsNullRepository: DictTopicOwnerEntityOrIsNullRepository

    override val filterDto: DictTopicOwnerEntityFilter
        get() = DictTopicOwnerEntityFilter.nullConst

    override fun orIsNullRepository(): OrIsNullRepository<DictTopicOwnerEntityFilter, DictTopicOwnerEntity> = orIsNullRepository

    override fun repository(): JpaRepository<DictTopicOwnerEntity, String> = dictTopicOwnerEntityRepository


    override val entityVal: DictTopicOwnerEntity
        get() = DictTopicOwnerEntity().apply {
            id = "test_id1"
            our = 1
            descriptionForReport = "test_id1 descriptionForReport"
        }
    override val pk: String
        get() = "test_id1"

//    @Test
//    fun findById() {
//        withTransactional {
//            val findById = dictTopicOwnerEntityRepository.findById("qwerty").get()
//            findById.our = 0
//            val save = dictTopicOwnerEntityRepository.save(findById)
//        }
//    }
//
//    @Test
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Rollback(false)
//    fun save() {
//        val apply = DictTopicOwnerEntity().apply {
//            id = "id1"
//            our = 1
//            descriptionForReport = "id1"
//        }
//        val save = dictTopicOwnerEntityRepository.save(apply)
//
//        val findById = dictTopicOwnerEntityRepository.findById("id1")
//
//        assertEquals(apply, findById.get())
//    }

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