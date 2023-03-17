package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity
import java.math.BigInteger
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@SpringBootTest
internal class DictTopicOwnerEntityRepositoryTest {

    @Autowired
    lateinit var dictTopicOwnerEntityRepository:DictTopicOwnerEntityRepository

    @PersistenceContext // or even @Autowired
    lateinit var entityManager: EntityManager

    @Test
    @Transactional
    fun findById() {



        val findById = dictTopicOwnerEntityRepository.findById("DKO_COMMAND").get()
        findById.isOur= BigInteger.valueOf(0)
        val save = dictTopicOwnerEntityRepository.save(findById)

        entityManager.persist(findById)
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
}