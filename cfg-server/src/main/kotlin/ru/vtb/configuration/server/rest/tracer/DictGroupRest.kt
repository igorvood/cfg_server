package ru.vtb.configuration.server.rest.tracer

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.repo.intf.DictGroupRepository

@RestController
@CrossOrigin
class DictGroupRest(
    private val dictGroupRepository: DictGroupRepository
) {
    @Operation(summary = "Получить связи для трекинга", tags = ["Связи"])
    @GetMapping("/tracking/group")
    fun groupList() = dictGroupRepository.groupList()
}