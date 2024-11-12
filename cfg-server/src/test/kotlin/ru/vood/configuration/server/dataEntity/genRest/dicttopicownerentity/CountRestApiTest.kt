package ru.vood.configuration.server.dataEntity.genRest.dicttopicownerentity

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.configuration.server.abstraction.AbstractTests
import ru.vood.processor.intf.IRestHibernateEntity
import kotlin.test.assertEquals

internal class CountRestApiTest : AbstractTests() {

    @Autowired
    lateinit var dictTopicOwnerEntityGeneratedRestApi: List<IRestHibernateEntity<*, *, *>>

    @Test
    fun countBeans() {
        assertEquals(9, dictTopicOwnerEntityGeneratedRestApi.size)
    }

}