package ru.vtb.configuration.server.controller

import org.springframework.stereotype.Service
import ru.vtb.configuration.server.controller.dto.PlaceHolder
import ru.vtb.configuration.server.controller.intf.extractNamesPlaceholder
import ru.vtb.configuration.server.controller.placeholder.intf.HolderResolver
import ru.vtb.configuration.server.controller.placeholder.intf.PlaceHoldersResolver
import ru.vtb.configuration.server.repo.dto.EnvProperty
import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.StandEnum
import java.util.*

@Service
class PlaceHoldersResolverImpl(
    holderResolvers: List<HolderResolver>
) : PlaceHoldersResolver {

    private val holdersFuns = holderResolvers.flatMap { f -> f.placeHolderName.map { n -> n to f } }.toMap()
    override fun placeHolders(
        property: List<EnvProperty>,
        flinkServiceProfile: FlinkServiceProfile,
        stand: StandEnum
    ): List<PlaceHolder> {
        val flatMap = property
            .filter { it.propertyValue.contains("\${") && it.propertyValue.contains("}") }
            .flatMap { prop -> extractNamesPlaceholder(prop.propertyValue) }
            .toSet()
        val propertyWithPlaceHolder = flatMap
            .flatMap { ph ->
                val valuePlaceHolder =
                    holdersFuns.get(ph)?.valuePlaceHolder(flinkServiceProfile, ph, stand)
                        ?.let { value -> PlaceHolder(ph, value) }
                Optional.ofNullable(valuePlaceHolder)
                    .map { q -> listOf(q) }
                    .orElseGet { listOf() }
            }

        return propertyWithPlaceHolder

    }
}