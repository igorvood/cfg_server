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

    @Autowired
    lateinit var configurationGeneratorRepositoryImpl: ConfigurationGeneratorRepositoryImpl


    private final val graphId = "test_graph"
    private final val serviceId = "test_service"
    private final val service = FlinkService(serviceId, "test.main.class")
    private final val profileId = "test_profile"
    private val reportDescription = "Описание не заполнено."
    private final val flinkServiceProfile = FlinkServiceProfile(service, profileId)
    val graphFlinkServiceProfile = GraphFlinkServiceProfile(
        graphId,
        flinkServiceProfile
    )
    val topicName = "test_topicName"
    val topicOwner = "DKO_COMMAND"
    val propertyGroup = "producer_default"
    val propertyKey = "property.topic.key"
    val propertyName = "property.name"
    val propertyValue = "property_value"


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
        val actual = reportTopicRepositoryImpl.unUsedTopics().filter { it == topicName }.toSet()
        assertEquals(setOf(), actual)
        fillDictRepositoryImpl.dictTopicInsert(graphId, topicName, topicOwner)
        assertEquals(
            setOf("test_topicName"),
            reportTopicRepositoryImpl.unUsedTopics().filter { it == topicName }.toSet()
        )
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
        assertEquals(setOf(), reportTopicRepositoryImpl.unUsedTopics().filter { it == topicName }.toSet())
    }

    @Test
    fun dictArrowInsertNoTransactional() {
        assertTransaction {
            fillDictRepositoryImpl.dictArrowInsert(
                DirectionEnum.OUT, graphId, serviceId, profileId, topicName,
                propertyKey, propertyGroup
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
            propertyKey, propertyGroup
        )

        val findByGraphId = pumlGeneratorRepositoryImpl.findByGraphId(graphId)

        assertEquals(
            setOf(
                Arrow(
                    from = FlinkSrvPuml(name = serviceId, profileId = profileId, reportDescription = reportDescription),
                    to = TopicPuml(
                        name = topicName,
                        topicOwnerId = "DKO_COMMAND",
                        topicGroup = "producer_default"
                    )
                )
            ), findByGraphId
        )
//Expected <[Arrow(from=FlinkSrvPuml(name=test_service, profileId=test_profile, reportDescription=reportDescription), to=TopicPuml(name=test_topicName, topicOwnerId=DKO_COMMAND, topicGroup=producer_default))]>,
        // actual <[Arrow(from=FlinkSrvPuml(name=test_service, profileId=test_profile, reportDescription=Описание не заполнено.), to=TopicPuml(name=test_topicName, topicOwnerId=DKO_COMMAND, topicGroup=producer_default))]>.
//Expected <[Arrow(from=FlinkSrvPuml(name=test_service, profileId=test_profile), to=TopicPuml(name=test_topicName, topicOwnerId=DKO_COMMAND, topicGroup=producer_prop_grp_ref1))]>,
        // actual <[Arrow(from=FlinkSrvPuml(name=test_service, profileId=test_profile), to=TopicPuml(name=test_topicName, topicOwnerId=DKO_COMMAND, topicGroup=producer_default))]>.
    }

    @Test
    fun dictFlinkPropertyInsertNoTransactional() {
        assertTransaction {
            fillDictRepositoryImpl.dictFlinkPropertyInsert(
                serviceId,
                profileId,
                PropertyDto(propertyName, propertyValue)
            )
        }
    }

    @Test
    @Transactional
    fun dictFlinkPropertyInsert() {
        val props: () -> List<EnvProperty> =
            { configurationGeneratorRepositoryImpl.propertyByService(serviceId, profileId, StandEnum.DSO) }

        assertEquals(listOf(), props())
        dictServiceInsertOk()
        fillDictRepositoryImpl.dictFlinkPropertyInsert(
            serviceId,
            profileId,
            PropertyDto(propertyName, propertyValue)
        )

        assertEquals(
            listOf(
                EnvProperty(
                    envPropertyName = propertyName,
                    propertyValue = propertyValue,
                    priority = 20,
                    typeProperty = "business"
                )
            ), props()
        )
    }

    @Test
    fun flinkPropertyDeleteNoTransactional() {
        assertTransaction {
            fillDictRepositoryImpl.flinkPropertyDelete(serviceId, profileId, propertyName)
        }
    }

    @Test
    @Transactional
    fun flinkPropertyDelete() {
        val props: () -> List<EnvProperty> =
            { configurationGeneratorRepositoryImpl.propertyByService(serviceId, profileId, StandEnum.DSO) }
        dictFlinkPropertyInsert()
        fillDictRepositoryImpl.flinkPropertyDelete(serviceId, profileId, propertyName)
        assertEquals(listOf(), props())
    }
}