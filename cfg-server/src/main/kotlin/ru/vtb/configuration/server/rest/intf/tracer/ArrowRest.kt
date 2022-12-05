package ru.vtb.configuration.server.rest.intf.tracer

import ru.vtb.configuration.server.controller.dto.tracer.JsonArrow

interface ArrowRest {
    fun arrowsByTopic(topicId: String): Set<JsonArrow>
}