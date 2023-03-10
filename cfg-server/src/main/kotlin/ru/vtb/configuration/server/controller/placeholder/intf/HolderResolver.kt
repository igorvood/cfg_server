package ru.vtb.configuration.server.controller.placeholder.intf

import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.StandEnum

interface HolderResolver {

    fun placeHolderName(): Set<String>

    fun valuePlaceHolder(flinkServiceProfile: FlinkServiceProfile, ph: String, stand: StandEnum): String
}