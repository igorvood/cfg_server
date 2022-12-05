package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.repo.dto.EnvProperty
import ru.vtb.configuration.server.repo.dto.StandEnum

interface ConfigurationGeneratorRepository {

    fun propertyByService(
        serviceId: String,
        profileId: String,
        stand: StandEnum,
    ): List<EnvProperty>

}