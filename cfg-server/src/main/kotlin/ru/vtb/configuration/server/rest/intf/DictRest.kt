package ru.vtb.configuration.server.rest.intf

import ru.vtb.configuration.server.repo.dto.FlinkService
import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.Graph

interface DictRest {

    fun graphList(): Set<Graph>

    fun serviceList(): Set<FlinkService>
    fun serviceProfile(serviceId: String): Set<FlinkServiceProfile>
}