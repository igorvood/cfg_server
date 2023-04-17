package ru.vtb.configuration.server.check

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.controller.intf.DictKafkaGrpController

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [TransactionalTestConfiguration::class]
)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransactionalTest {
    @MockBean
    lateinit var checkRunner: CheckRunner


    @Autowired
    lateinit var transactionTestBeanPostProcessor: TransactionTestBeanPostProcessor

    @Autowired
    lateinit var DictKafkaGrpController: DictKafkaGrpController


    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun asdf() {
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