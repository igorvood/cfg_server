package ru.vtb.configuration.server.rest.intf

import ru.vtb.configuration.server.repo.dto.EviromentService
import ru.vtb.configuration.server.repo.dto.StandEnum

interface ConfigurationGeneratorRest {
    fun allServiceProfileByStand(
        serviceId: String,
        stand: StandEnum
    ): List<EviromentService>

    fun generateEnvBody(
        serviceId: String,
        profileId: String,
        stand: StandEnum
    ): String

    fun environmentZip(serviceId: String): ByteArray

    fun environmentZipAll(serviceId: String): ByteArray
}