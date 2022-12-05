package ru.vtb.configuration.server.controller.placeholder.intf

import ru.vtb.configuration.server.controller.dto.PlaceHolder
import ru.vtb.configuration.server.repo.dto.EnvProperty
import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.StandEnum

interface PlaceHoldersResolver {

    fun placeHolders(
        property: List<EnvProperty>,
        flinkServiceProfile: FlinkServiceProfile,
        stand: StandEnum
    ): List<PlaceHolder>

}
