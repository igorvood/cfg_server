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
import kotlin.test.assertEquals


internal class DictTopicOwnerEntityRepositoryTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var applicationContext: ApplicationContext


    @Autowired
    lateinit var dictTopicOwnerEntityRepository: DictTopicOwnerEntityRepository


    @Transactional
    @Rollback(false)
    fun <R>withTransactional(block: ()->R): R = block.invoke()


    @Test
    fun findById() {
        withTransactional {
            val findById = dictTopicOwnerEntityRepository.findById("qwerty").get()
            findById.isOur = BigInteger.valueOf(0)
            val save = dictTopicOwnerEntityRepository.save(findById)
        }
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Rollback(false)
    fun save() {


        val apply = DictTopicOwnerEntity().apply {
            id = "id1"
            isOur = BigInteger.valueOf(1)
            descriptionForReport = "id1"
        }
        val save = dictTopicOwnerEntityRepository.save(apply)

        val findById = dictTopicOwnerEntityRepository.findById("id1")

        assertEquals(apply, findById.get())
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Rollback(false)
    fun update() {
        val id = "qwerty"
//        val id = "DKO_COMMAND"

        val update = dictTopicOwnerEntityRepository.update(
            id, id + "asd"
//            ,DictTopicOwnerEntity("asd",BigInteger.ZERO,"asd")
        )

        assertEquals(1, update)
    }
}