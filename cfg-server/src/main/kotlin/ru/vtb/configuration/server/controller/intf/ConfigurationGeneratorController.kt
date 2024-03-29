package ru.vtb.configuration.server.controller.intf

import ru.vtb.configuration.server.controller.dto.EnvironmentService
import ru.vtb.configuration.server.repo.dto.StandEnum

interface ConfigurationGeneratorController {

    fun generateEnvBody(
        serviceId: String,
        profileId: String,
        stand: StandEnum
    ): String


    fun generateAllServiceProfile(
        serviceId: String,
        stand: StandEnum
    ): List<EnvironmentService>

    fun environmentZip(serviceId: String, nonLocalStandOnly: Boolean): ByteArray
}