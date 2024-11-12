package ru.vood.configuration.server.rest.intf

import ru.vood.configuration.server.controller.dto.EnvironmentService
import ru.vood.configuration.server.repo.dto.StandEnum

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

    fun repTopics(groupId: String): ByteArray
}