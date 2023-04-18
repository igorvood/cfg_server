package kaptKotlin.compile

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityFilter

internal class DictAbstractGraphNodeEntityFilterTest {

    @Test
    fun cleanAllNull() {

        val dictAbstractGraphNodeEntityFilter = DictAbstractGraphNodeEntityFilter(null, null, null)

        val clean = dictAbstractGraphNodeEntityFilter.clean()

        assertEquals("asdsa", clean)

    }

    @Test
    fun cleanAllNotNull() {

        val d = DictAbstractGraphNodeEntityFilter("graphId", "nodeType", "nodeId")

        val clean = d.clean()

        assertEquals("asdsa", clean)

    }
}