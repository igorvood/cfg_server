package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import java.math.BigInteger


internal class DictTopicOwnerEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var applicationContext: ApplicationContext


    @Autowired
    lateinit var dictTopicOwnerEntityRepository: DictTopicOwnerEntityRepository

//    @PersistenceContext // or even @Autowired
//    lateinit var entityManager: EntityManager

    @Test
    @Transactional
    fun findById() {


        val findById = dictTopicOwnerEntityRepository.findById("DKO_COMMAND").get()
        findById.isOur = BigInteger.valueOf(0)
        val save = dictTopicOwnerEntityRepository.save(findById)


        println(findById)
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun save() {


        val apply = DictTopicOwnerEntity().apply {
            id = "id1"
            isOur = BigInteger.valueOf(1)
            descriptionForReport = "id1"
        }
        val save = dictTopicOwnerEntityRepository.save(apply)

        val findById = dictTopicOwnerEntityRepository.findById("id1")

        println(save)
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Rollback(false)
    fun update() {
        val id = "DKO_COMMAND"
//        val findById = dictTopicOwnerEntityRepository.findById(id).get()

        dictTopicOwnerEntityRepository.update(
            id, id + "asd"
//            ,DictTopicOwnerEntity("asd",BigInteger.ZERO,"asd")
        )

    }
}