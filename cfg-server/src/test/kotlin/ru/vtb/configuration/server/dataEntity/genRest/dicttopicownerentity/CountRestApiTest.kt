package ru.vtb.configuration.server.dataEntity.genRest.dicttopicownerentity

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.abstraction.AbstractTests
import ru.vtb.processor.intf.IRestHibernateEntity
import kotlin.test.assertEquals

internal class CountRestApiTest : AbstractTests() {

    @Autowired
    lateinit var dictTopicOwnerEntityGeneratedRestApi: List<IRestHibernateEntity<*, *, *>>

    @Test
    fun countBeans() {
        assertEquals(5, dictTopicOwnerEntityGeneratedRestApi.size)
    }

}