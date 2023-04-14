package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import java.math.BigInteger
import kotlin.test.assertContains
import kotlin.test.assertEquals

internal class DictTopicOwnerEntityGeneratedRestApiTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicOwnerEntityGeneratedRestApi: DictTopicOwnerEntityGeneratedRestApi



    @Test
    fun findById() {
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findById("DKO_COMMAND")
        assertTrue(findAll.isPresent)
    }

    @Test
    fun findByIdNotPresent() {
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findById("zxfgsdgsdfg")
        assertTrue(!findAll.isPresent)
    }


    @Test
    fun findAll() {
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findAll()
        assertTrue(findAll.isNotEmpty())
    }

    @Test
    fun save() {
        val expected = DictTopicOwnerEntityImmutable("id_1", BigInteger.valueOf(1), "desc")
        val actual = dictTopicOwnerEntityGeneratedRestApi.save(expected)
        assertEquals(expected, actual)
    }

    @Test
    fun deleteById() {
        val id = "id_1"
        val expected = DictTopicOwnerEntityImmutable(id, BigInteger.valueOf(1), "desc")
        val actual = dictTopicOwnerEntityGeneratedRestApi.save(expected)
        dictTopicOwnerEntityGeneratedRestApi.deleteById(id)
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findAll()
        assertTrue(!findAll.contains(expected))
    }

    @Test
    fun editEntity() {
        val id = "id_1"
        val expected = DictTopicOwnerEntityImmutable(id, BigInteger.valueOf(1), "desc")
        val actual = dictTopicOwnerEntityGeneratedRestApi.save(expected)

        val newData = actual.copy(descriptionForReport = "other_desc")
        val editEntity = dictTopicOwnerEntityGeneratedRestApi.editEntity(id, newData)
        assertEquals(newData, editEntity)
    }

    @Test
    fun editNotExistingEntity() {
        val id = "id_1"
        val expected = DictTopicOwnerEntityImmutable(id, BigInteger.valueOf(1), "desc")
        val editEntity = dictTopicOwnerEntityGeneratedRestApi.editEntity(id, expected)
        assertEquals(null, editEntity)
    }
}