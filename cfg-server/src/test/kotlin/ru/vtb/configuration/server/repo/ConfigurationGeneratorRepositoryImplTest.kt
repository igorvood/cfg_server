package ru.vtb.configuration.server.repo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.repo.dto.EnvProperty
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class ConfigurationGeneratorRepositoryImplTest : AbstractDatasourceTests() {


    @Autowired
    lateinit var configurationGeneratorRepositoryImpl: ConfigurationGeneratorRepositoryImpl

    @Test
    fun propertyByServiceNoService() {
        val propertyByService = configurationGeneratorRepositoryImpl.propertyByService("asd", "sad", StandEnum.DSO)
        assertEquals(listOf<EnvProperty>(), propertyByService)
    }

    @Test
    fun propertyByService() {
                val propertyByService = configurationGeneratorRepositoryImpl.propertyByService(
                    "service_id_1",
                    "profile_id_1",
                    StandEnum.DSO
                )
                assertEquals(listOf(
                    EnvProperty(envPropertyName="service_topic_name_prop_id_1", propertyValue="prop_value_1", priority=10, typeProperty="topic_name"),
                    EnvProperty(envPropertyName="flink_property_prop_id_1", propertyValue="prop_value_1", priority=20, typeProperty="business"),
                    EnvProperty(envPropertyName="kafka_property_env_prop_name_1", propertyValue="property_val_1", priority=99, typeProperty="kafka")
                ), propertyByService)
    }

}