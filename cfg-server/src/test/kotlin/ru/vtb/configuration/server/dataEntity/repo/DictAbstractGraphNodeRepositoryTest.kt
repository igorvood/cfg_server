package ru.vtb.configuration.server.dataEntity.repo

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK

@SpringBootTest
internal class DictAbstractGraphNodeRepositoryTest {

    @Autowired
    lateinit var dictAbstractGraphNodeRepository:DictAbstractGraphNodeRepository

    @Test
    @Transactional
    fun save() {
        val dictAbstractGraphNodeEntityPK = DictAbstractGraphNodeEntityPK()
            .apply {
                graphId="rto_graph"
                nodeId="APRF_STATIC_PUB"
                nodeType="topic"

            }


        val findById = dictAbstractGraphNodeRepository.findById(dictAbstractGraphNodeEntityPK)

        println(findById)
    }
}