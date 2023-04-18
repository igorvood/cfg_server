package ru.vtb.configuration.server.dataEntity.filter

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityFilter

internal class DictAbstractGraphNodeEntityFilterTest {

    @Test
    fun cleanAllNull() {
        val dictAbstractGraphNodeEntityFilter = DictAbstractGraphNodeEntityFilter(null, null, null)
        val clean = dictAbstractGraphNodeEntityFilter.clean()
        assertEquals("select d from DictAbstractGraphNodeEntity d where 1=1 and (d.graphId = :graphId or (1=1)) and (d.nodeType = :nodeType or (1=1)) and (d.nodeId = :nodeId or (1=1))", clean)
    }

    @Test
    fun cleanAllNotNull() {

        val d = DictAbstractGraphNodeEntityFilter("graphId", "nodeType", "nodeId")

        val clean = d.clean()

        assertEquals("select d from DictAbstractGraphNodeEntity d where 1=1 and (d.graphId = :graphId or (1!=1)) and (d.nodeType = :nodeType or (1!=1)) and (d.nodeId = :nodeId or (1!=1))", clean)

    }
}