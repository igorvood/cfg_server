package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.repo.dto.FlinkService
import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.Graph
import ru.vtb.configuration.server.repo.intf.DictRepository
import ru.vtb.configuration.server.rest.intf.DictRest

@RestController
class DictRestImpl(
    private val dictRepository: DictRepository
) : DictRest {

    @Operation(summary = "Список графов", tags = ["Отчеты."])
    @GetMapping("/graphList", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun graphList(): Set<Graph> {
        return dictRepository.graphList()
    }

    @Operation(summary = "Список вервисов", tags = ["Отчеты."])
    @GetMapping("/serviceList", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun serviceList(): Set<FlinkService> {
        return dictRepository.serviceList()
    }

    @Operation(summary = "Список имен профилей для сервиса", tags = ["Отчеты."])
    @GetMapping("/serviceProfile", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun serviceProfile(serviceId: String): Set<FlinkServiceProfile> {
        return dictRepository.serviceProfile(serviceId)
    }
}