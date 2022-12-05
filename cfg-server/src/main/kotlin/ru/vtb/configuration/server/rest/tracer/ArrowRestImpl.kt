package ru.vtb.configuration.server.rest.tracer

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.controller.dto.tracer.JsonArrow
import ru.vtb.configuration.server.controller.intf.tracer.ArrowController
import ru.vtb.configuration.server.rest.intf.tracer.ArrowRest

@RestController
class ArrowRestImpl(val arrowController: ArrowController) : ArrowRest {

    @Operation(summary = "Получить связи для трекинга", tags = ["Связи"])
    @GetMapping("/arrows/byTopic/{topicId}")
    override fun arrowsByTopic(@PathVariable topicId: String): Set<JsonArrow> {
        return arrowController.arrowsByTopic(topicId)
    }
}