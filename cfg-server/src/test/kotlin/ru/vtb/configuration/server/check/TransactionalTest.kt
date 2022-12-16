package ru.vtb.configuration.server.check

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.controller.intf.DictKafkaGrpController
import ru.vtb.configuration.server.repo.DictRepositoryImpl
import ru.vtb.configuration.server.test.abstraction.AbstractTests

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = [TransactionalTestConfiguration::class])
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransactionalTest {

    @Autowired
    lateinit var transactionTestBeanPostProcessor: TransactionTestBeanPostProcessor

    @Autowired
    lateinit var DictKafkaGrpController: DictKafkaGrpController


    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun asdf(){
// todo надо проверять правильность расстановки транзакшинал
//        DictKafkaGrpController.kafkaPropertyDelete("Asd",Direction.prd)

        val transactionalMethods1 = transactionTestBeanPostProcessor.transactionalMethods
        val transactionalMethods = transactionalMethods1
            .flatMap { it.value.toList() }
            .map { it.name }
        println(transactionalMethods)
//        println(transactionalMethods.map { it.value. })
    }




}