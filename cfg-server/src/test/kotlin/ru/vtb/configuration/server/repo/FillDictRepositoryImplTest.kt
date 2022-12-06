package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.repo.dto.FlinkService
import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.GraphFlinkServiceProfile
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests
import ru.vtb.configuration.server.test.util.assertTransaction

internal class FillDictRepositoryImplTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var fillDictRepositoryImpl: FillDictRepositoryImpl

    val graphId = "test_graph"
    val flinkServiceProfile = FlinkServiceProfile(FlinkService("test_service", "test.main.class"), "test_profile")
    val graphFlinkServiceProfile = GraphFlinkServiceProfile(
        graphId,
        flinkServiceProfile
    )


    @Test
    fun dictServiceInsert() {
        assertTransaction {
            fillDictRepositoryImpl.dictServiceInsert(
                graphFlinkServiceProfile
            )
        }

    }

    @Test
    fun dictServiceDelete() {
    }

    @Test
    fun dictTopicInsert() {
    }

    @Test
    fun dictTopicDelete() {
    }

    @Test
    fun dictArrowInsert() {
    }

    @Test
    fun dictFlinkPropertyInsert() {
    }

    @Test
    fun flinkPropertyDelete() {
    }
}