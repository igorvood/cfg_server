package ru.vtb.configuration.server.rest.intf

import ru.vtb.configuration.server.repo.dto.EnvironmentService
import ru.vtb.configuration.server.repo.dto.StandEnum

interface ConfigurationGeneratorRest {
    fun allServiceProfileByStand(
        serviceId: String,
        stand: StandEnum
    ): List<EnvironmentService>

    fun generateEnvBody(
        serviceId: String,
        profileId: String,
        stand: StandEnum
    ): String

    fun environmentZip(serviceId: String): ByteArray

    fun environmentZipAll(serviceId: String): ByteArray
}