package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.repo.dto.DataBasePlaceHolder
import ru.vtb.configuration.server.repo.dto.StandEnum

interface PlaceHolderRepository {

    fun dbPlaceHolders(): Set<DataBasePlaceHolder>

    fun placeHolderByService(
        serviceId: String,
        profileId: String,
        stand: StandEnum,
        placeHolderName: String
    ): String


}