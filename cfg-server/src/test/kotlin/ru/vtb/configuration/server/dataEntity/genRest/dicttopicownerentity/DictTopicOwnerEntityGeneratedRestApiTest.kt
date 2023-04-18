package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.ui.controler.EditableTableDataDto
import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import ru.vtb.processor.wrapper.RestEditEntityDto
import java.math.BigInteger
import kotlin.test.assertContains
import kotlin.test.assertEquals

internal class DictTopicOwnerEntityGeneratedRestApiTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var dictTopicOwnerEntityGeneratedRestApi: DictTopicOwnerEntityGeneratedRestApi



    @Test
    fun findById() {
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findById(PrimaryKeyWrapper("DKO_COMMAND"))
        assertTrue(findAll.isPresent)
    }

    @Test
    fun findByIdNotPresent() {
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findById(PrimaryKeyWrapper("zxfgsdgsdfg"))
        assertTrue(!findAll.isPresent)
    }


    @Test
    fun findAll() {
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findAll()
        assertTrue(findAll.isNotEmpty())
    }

    @Test
    fun save() {
        val expected = DictTopicOwnerEntityImmutable("id_1", true, "desc")
        val actual = dictTopicOwnerEntityGeneratedRestApi.save(expected)
        assertEquals(expected, actual)
    }

    @Test
    fun deleteById() {
        val id = "id_1"
        val expected = DictTopicOwnerEntityImmutable(id, true, "desc")
        val actual = dictTopicOwnerEntityGeneratedRestApi.save(expected)
        dictTopicOwnerEntityGeneratedRestApi.deleteById(PrimaryKeyWrapper(id))
        val findAll = dictTopicOwnerEntityGeneratedRestApi.findAll()
        assertTrue(!findAll.contains(expected))
    }

    @Test
    fun editEntity() {
        val id = "id_1"
        val expected = DictTopicOwnerEntityImmutable(id, true, "desc")
        val actual = dictTopicOwnerEntityGeneratedRestApi.save(expected)

        val newData = actual.copy(descriptionForReport = "other_desc")
        val editEntity = dictTopicOwnerEntityGeneratedRestApi.editEntity(RestEditEntityDto(PrimaryKeyWrapper(id), newData))
        assertEquals(newData, editEntity)
    }

    @Test
    fun editNotExistingEntity() {
        val id = "id_1"
        val expected = DictTopicOwnerEntityImmutable(id, true, "desc")
        val editEntity = dictTopicOwnerEntityGeneratedRestApi.editEntity(RestEditEntityDto(PrimaryKeyWrapper(id), expected))
        assertEquals(null, editEntity)
    }
}