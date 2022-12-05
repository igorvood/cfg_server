package ru.vtb.configuration.server.controller.intf.tracer

import ru.vtb.configuration.server.controller.dto.tracer.JsonArrow

interface ArrowController {

    fun arrowsByTopic(topicId: String): Set<JsonArrow>
}