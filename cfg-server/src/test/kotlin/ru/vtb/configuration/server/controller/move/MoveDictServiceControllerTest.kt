package ru.vtb.configuration.server.controller.move

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import ru.vtb.configuration.server.repo.dto.EnvProperty
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.repo.intf.ConfigurationGeneratorRepository
import ru.vtb.configuration.server.rest.update.IUpdateDictServiceRest
import ru.vtb.configuration.server.test.abstraction.AbstractDatasourceTests

internal class MoveDictServiceControllerTest: AbstractDatasourceTests() {

    @Autowired
    lateinit var iUpdateDictServiceRest: IUpdateDictServiceRest

    @Autowired
    lateinit var configurationGeneratorRepository: ConfigurationGeneratorRepository
    val serviceId = "uasp-streaming-mdm-enrichment"
    val profileId = "profile-tx-step1"


    @Test
    fun moveDictService() {
        val propertyByServiceExpected = configurationGeneratorRepository.propertyByService(serviceId, profileId, StandEnum.P0)

        val newProfile = profileId + "_1"
        iUpdateDictServiceRest.moveDictService(serviceId
            ,profileId,newProfile
        )

        val propertyByServiceActual = configurationGeneratorRepository.propertyByService(serviceId, newProfile, StandEnum.P0)

        val minus = propertyByServiceExpected.minus(propertyByServiceActual.toSet())
        Assertions.assertEquals(listOf<EnvProperty>(), minus){ minus.joinToString("\n") { it.toString() } }
        Assertions.assertEquals(listOf<EnvProperty>(),        propertyByServiceActual.minus(propertyByServiceExpected.toSet()))


    }
}