package ru.vtb.configuration.server.controller.tracer

import org.springframework.stereotype.Service
import ru.vtb.configuration.server.controller.PumlGeneratorControllerImpl
import ru.vtb.configuration.server.controller.dto.FlinkSrvPuml
import ru.vtb.configuration.server.controller.dto.GraphNode
import ru.vtb.configuration.server.controller.dto.TopicPuml
import ru.vtb.configuration.server.controller.dto.tracer.FlinkSrvJson
import ru.vtb.configuration.server.controller.dto.tracer.GraphNodeJson
import ru.vtb.configuration.server.controller.dto.tracer.JsonArrow
import ru.vtb.configuration.server.controller.dto.tracer.TopicJson
import ru.vtb.configuration.server.controller.intf.tracer.ArrowController
import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.intf.PumlGeneratorRepository

@Service
class ArrowControllerImpl(val pumlGeneratorRepository: PumlGeneratorRepository) : ArrowController {
    override fun arrowsByTopic(topicId: String): Set<JsonArrow> {
        val findByTopic = pumlGeneratorRepository.findByTopic(topicId)
        val cutArrows = PumlGeneratorControllerImpl.cutArrows(findByTopic, topicId, DirectionEnum.OUT)
        return cutArrows.map { JsonArrow.of(it.from.toJsonDto(), it.to.toJsonDto()) }.toSet()
    }
}

fun GraphNode.toJsonDto(): GraphNodeJson {
    return when (val graphNode = this) {
        is TopicPuml -> TopicJson(graphNode.name)
        is FlinkSrvPuml -> FlinkSrvJson(graphNode.name, graphNode.profileId)
    }
}