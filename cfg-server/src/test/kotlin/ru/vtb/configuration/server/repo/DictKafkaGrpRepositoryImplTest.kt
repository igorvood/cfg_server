package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.IllegalTransactionStateException
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.controller.dto.KafkaPropertyGrp
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class DictKafkaGrpRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictKafkaGrpRepositoryImpl: DictKafkaGrpRepositoryImpl


    @Test
    fun kafkaPropertyGrpList() {
        val kafkaPropertyGrpList = dictKafkaGrpRepositoryImpl.kafkaPropertyGrpList()
            .filter { it.id in listOf("test_id_1", "test_id_2") }

        assertEquals(listOf<KafkaPropertyGrp>(
            KafkaPropertyGrp(id="test_id_2", typeRead= Direction.cns, description="description_2"),
            KafkaPropertyGrp(id="test_id_1", typeRead= Direction.prd, description="description_1")
        ), kafkaPropertyGrpList)
    }

    @Test
    fun kafkaPropertyGrp() {
        val kafkaPropertyGrpPrd = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_1", Direction.prd)
        assertEquals(setOf(PropertyDto("retries","1")), kafkaPropertyGrpPrd)
        val kafkaPropertyGrpCns = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_2", Direction.cns)
        assertEquals(setOf(PropertyDto("connections.max.idle.ms","100")), kafkaPropertyGrpCns)
    }

    @Test
    fun kafkaPropertyGrpDeleteNoTransaction() {
        val message = assertThrows<IllegalTransactionStateException> {
            dictKafkaGrpRepositoryImpl.kafkaPropertyGrpDelete(
                "test_id_1",
                Direction.prd
            )
        }            .message
        assertEquals("No existing transaction found for transaction marked with propagation 'mandatory'", message)
    }

    @Test
    @Transactional
    fun kafkaPropertyGrpDeleteOK() {
        val kafkaPropertyGrpPrd1 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_1", Direction.prd)
        assertEquals(setOf(PropertyDto("retries","1")), kafkaPropertyGrpPrd1)

        val kafkaPropertyGrpDelete = dictKafkaGrpRepositoryImpl.kafkaPropertyGrpDelete(
            "test_id_1",
            Direction.prd
        )

        assertEquals(1,kafkaPropertyGrpDelete)

        val kafkaPropertyGrpPrd2 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_1", Direction.prd)
        assertEquals(setOf<PropertyDto>(), kafkaPropertyGrpPrd2)
    }

    @Test
    fun kafkaPropertyEditNoTransaction() {
        val message = assertThrows<IllegalTransactionStateException> {
            dictKafkaGrpRepositoryImpl.kafkaPropertyEdit(
                "test_id_1",
                Direction.prd,
                PropertyDto("sad","asd")
            )
        }            .message
        assertEquals("No existing transaction found for transaction marked with propagation 'mandatory'", message)
    }

    @Test
    @Transactional
    fun kafkaPropertyEditOk() {
        val element = PropertyDto("retries", "1")
        val kafkaPropertyGrpPrd1 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_1", Direction.prd)

        assertEquals(setOf(element), kafkaPropertyGrpPrd1)

        val newProp = element.copy(value = "2")
        val kafkaPropertyGrpDelete = dictKafkaGrpRepositoryImpl.kafkaPropertyEdit(
            "test_id_1",
            Direction.prd,
            newProp
        )

        assertEquals(1,kafkaPropertyGrpDelete)

        val kafkaPropertyGrpPrd2 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_1", Direction.prd)
        assertEquals(setOf(newProp), kafkaPropertyGrpPrd2)
    }

    @Test
    fun kafkaPropertyAddNoTransaction() {
        val message = assertThrows<IllegalTransactionStateException> {
            dictKafkaGrpRepositoryImpl.kafkaPropertyAdd(
                "test_id_100",
                Direction.prd,
                PropertyDto("retries", "1")
            )
        }            .message
        assertEquals("No existing transaction found for transaction marked with propagation 'mandatory'", message)
    }

    @Test
    @Transactional
    fun kafkaPropertyAddOk() {
        val element = PropertyDto("retries", "1")
        val kafkaPropertyGrpPrd1 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_100", Direction.prd)

        assertEquals(setOf<PropertyDto>(), kafkaPropertyGrpPrd1)


        dictKafkaGrpRepositoryImpl.kafkaPropertyGrpAdd(            "test_id_100",            Direction.prd,"asd"        )

        val kafkaPropertyGrpDelete = dictKafkaGrpRepositoryImpl.kafkaPropertyAdd(
            "test_id_100",
            Direction.prd,
            element
        )

        assertEquals(1,kafkaPropertyGrpDelete)

        val kafkaPropertyGrpPrd2 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("test_id_100", Direction.prd)
        assertEquals(setOf(element), kafkaPropertyGrpPrd2)
    }

    @Test
    fun kafkaPropertyGrpAddNoTransaction() {

        val message = assertThrows<IllegalTransactionStateException> {
            dictKafkaGrpRepositoryImpl.kafkaPropertyGrpAdd(            "test_id_100",            Direction.prd,"asd"        )}            .message
        assertEquals("No existing transaction found for transaction marked with propagation 'mandatory'", message)

    }

    @Test
    @Transactional
    fun kafkaPropertyGrpAddOk() {

        val kafkaPropertyGrpPrd1 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrpList()
            .filter { it.id == "test_id_100" }

        assertEquals(listOf<KafkaPropertyGrp>(), kafkaPropertyGrpPrd1)


        val kafkaPropertyGrpDelete = dictKafkaGrpRepositoryImpl.kafkaPropertyGrpAdd(            "test_id_100",            Direction.prd,"asd"        )


        assertEquals(1,kafkaPropertyGrpDelete)

        val kafkaPropertyGrpPrd2 = dictKafkaGrpRepositoryImpl.kafkaPropertyGrpList()
            .filter { it.id == "test_id_100" }

        assertEquals(listOf<KafkaPropertyGrp>(KafkaPropertyGrp(id="test_id_100", typeRead= Direction.prd, description="asd")), kafkaPropertyGrpPrd2)

    }

}