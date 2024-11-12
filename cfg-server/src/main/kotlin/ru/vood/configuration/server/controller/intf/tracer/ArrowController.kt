package ru.vood.configuration.server.controller.intf.tracer

import ru.vood.configuration.server.controller.dto.tracer.JsonArrow

interface ArrowController {

    fun arrowsByGroupId(GroupId: String): Set<JsonArrow>
}