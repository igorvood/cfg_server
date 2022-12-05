package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class DictKafkaGrpRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictKafkaGrpRepositoryImpl: DictKafkaGrpRepositoryImpl


    @Test
    fun kafkaPropertyGrpList() {
        val kafkaPropertyGrpList = dictKafkaGrpRepositoryImpl.kafkaPropertyGrpList()
        assertEquals(3, kafkaPropertyGrpList.size)
    }

    @Test
    fun kafkaPropertyGrp() {
        val kafkaPropertyGrp = dictKafkaGrpRepositoryImpl.kafkaPropertyGrp("producer_default", Direction.prd)
        assertEquals(11, kafkaPropertyGrp.size)
    }

    @Test
    @Disabled
    fun kafkaPropertyGrpDelete() {
        dictKafkaGrpRepositoryImpl.kafkaPropertyGrpDelete("producer_default", Direction.prd)

    }

    @Test
    @Disabled
    fun kafkaPropertyEdit() {
    }

    @Test
    @Disabled
    fun kafkaPropertyAdd() {
    }

    @Test
    @Disabled
    fun kafkaPropertyGrpAdd() {
    }
}