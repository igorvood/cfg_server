package ru.vtb.configuration.server.delete

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityFilter

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class asdasdTest {

    @Autowired
    lateinit var asdasd: asdasd

    @Test
    fun findByFilterOrIsNull() {
        val findByFilterOrIsNull = asdasd.findByFilterOrIsNull(DictAbstractGraphNodeEntityFilter(null, null, null,))
        assertEquals(307, findByFilterOrIsNull.size)
    }

    @Test
    fun findByFilterOrIsNull1() {
        val findByFilterOrIsNull = asdasd.findByFilterOrIsNull(DictAbstractGraphNodeEntityFilter(null, "topic", null,))
        assertEquals(224, findByFilterOrIsNull.size)
    }

}