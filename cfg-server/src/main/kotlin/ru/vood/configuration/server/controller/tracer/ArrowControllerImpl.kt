package ru.vood.configuration.server.controller.tracer

import org.springframework.stereotype.Service
import ru.vood.configuration.server.controller.dto.FlinkSrvPuml
import ru.vood.configuration.server.controller.dto.GraphNode
import ru.vood.configuration.server.controller.dto.TopicPuml
import ru.vood.configuration.server.controller.dto.tracer.FlinkSrvJson
import ru.vood.configuration.server.controller.dto.tracer.GraphNodeJson
import ru.vood.configuration.server.controller.dto.tracer.JsonArrow
import ru.vood.configuration.server.controller.dto.tracer.TopicJson
import ru.vood.configuration.server.controller.intf.tracer.ArrowController
import ru.vood.configuration.server.repo.intf.PumlGeneratorRepository

@Service
class ArrowControllerImpl(val pumlGeneratorRepository: PumlGeneratorRepository) : ArrowController {
    override fun arrowsByGroupId(GroupId: String): Set<JsonArrow> {
        val findByTopic = pumlGeneratorRepository.findByGroupId(GroupId)
//        val cutArrows = PumlGeneratorControllerImpl.cutArrows(findByTopic, GroupId, DirectionEnum.OUT)
        return findByTopic.map { JsonArrow(it.from.toJsonDto(), it.to.toJsonDto()) }.toSet()
    }
}

fun GraphNode.toJsonDto(): GraphNodeJson {
    return when (val graphNode = this) {
        is TopicPuml -> TopicJson(name = graphNode.name)
        is FlinkSrvPuml -> FlinkSrvJson(name = graphNode.name, profileId = graphNode.profileId)
    }
}