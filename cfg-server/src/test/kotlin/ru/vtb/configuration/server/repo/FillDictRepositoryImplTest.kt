package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.controller.dto.Arrow
import ru.vtb.configuration.server.controller.dto.FlinkSrvPuml
import ru.vtb.configuration.server.controller.dto.TopicPuml
import ru.vtb.configuration.server.repo.dto.*
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.test.util.assertTransaction
import kotlin.test.assertContains
import kotlin.test.assertEquals

internal class FillDictRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var fillDictRepositoryImpl: FillDictRepositoryImpl


    @Autowired
    lateinit var dictRepositoryImpl: DictRepositoryImpl

    @Autowired
    lateinit var reportTopicRepositoryImpl: ReportTopicRepositoryImpl

    @Autowired
    lateinit var pumlGeneratorRepositoryImpl: PumlGeneratorRepositoryImpl


    private final val graphId = "test_graph"
    private final val serviceId = "test_service"
    private final val service = FlinkService(serviceId, "test.main.class")
    private final val profileId = "test_profile"
    private final val flinkServiceProfile = FlinkServiceProfile(service, profileId)
    val graphFlinkServiceProfile = GraphFlinkServiceProfile(
        graphId,
        flinkServiceProfile
    )
    val topicName = "test_topicName"
    val topicOwner = "DKO_COMMAND"
    val propertyKey = "property.topic.key"

    @Test
    fun dictServiceInsertNoTransaction() {
        assertTransaction {
            fillDictRepositoryImpl.dictServiceInsert(
                graphFlinkServiceProfile
            )
        }
    }

    @Test
    @Transactional
    fun dictServiceInsertOk() {

        fillDictRepositoryImpl.dictServiceInsert(
            graphFlinkServiceProfile
        )
        val serviceById = dictRepositoryImpl.serviceById(serviceId)
        assertEquals(service, serviceById)

        val graphList = dictRepositoryImpl.graphList()
        assertContains(graphList, Graph(graphId))

    }

    @Test
    fun dictServiceDeleteNoTransactional() {
        assertTransaction {
            fillDictRepositoryImpl.dictServiceDelete(serviceId, profileId)
        }
    }


    @Test
    @Transactional
    fun dictServiceDelete() {
        dictServiceInsertOk()
        val dictServiceDelete = fillDictRepositoryImpl.dictServiceDelete(serviceId, profileId)
        assertEquals(1, dictServiceDelete)
    }

    @Test
    fun dictTopicInsertNoTransactional() {

        assertTransaction {
            fillDictRepositoryImpl.dictTopicInsert(graphId, topicName, topicOwner)
        }
    }

    @Test
    @Transactional
    fun dictTopicInsert() {
        assertEquals(setOf(), reportTopicRepositoryImpl.unUsedTopics())
        fillDictRepositoryImpl.dictTopicInsert(graphId, topicName, topicOwner)
        assertEquals(setOf("test_topicName"), reportTopicRepositoryImpl.unUsedTopics())
    }

    @Test
    fun dictTopicDeleteNoTransactional() {
        assertTransaction {
            fillDictRepositoryImpl.dictTopicDelete(topicName)
        }
    }

    @Test
    @Transactional
    fun dictTopicDelete() {
        dictTopicInsert()
        val dictTopicDelete = fillDictRepositoryImpl.dictTopicDelete(topicName)
        assertEquals(1, dictTopicDelete)
        assertEquals(setOf(), reportTopicRepositoryImpl.unUsedTopics())
    }

    @Test
    fun dictArrowInsertNoTransactional() {
        assertTransaction {
            fillDictRepositoryImpl.dictArrowInsert(
                DirectionEnum.OUT, graphId, serviceId, profileId, topicName,
                propertyKey
            )
        }
    }

    @Test
    @Transactional
    fun dictArrowInsert() {
        dictTopicInsert()
        dictServiceInsertOk()

        fillDictRepositoryImpl.dictArrowInsert(
            DirectionEnum.OUT, graphId, serviceId, profileId, topicName,
            propertyKey
        )

        val findByGraphId = pumlGeneratorRepositoryImpl.findByGraphId(graphId)

        assertEquals(
            setOf(
                Arrow(
                    from = FlinkSrvPuml(name = serviceId, profileId = profileId),
                    to = TopicPuml(
                        name = topicName,
                        isOur = true,
                        producerGrp = "producer_default",
                        consumerGrp = "consumer_default"
                    )
                )
            ), findByGraphId
        )

    }

    @Test
    fun dictFlinkPropertyInsert() {
    }

    @Test
    fun flinkPropertyDelete() {
    }
}