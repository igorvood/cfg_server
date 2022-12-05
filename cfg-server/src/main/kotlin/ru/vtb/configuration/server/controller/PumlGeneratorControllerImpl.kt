package ru.vtb.configuration.server.controller

import org.springframework.stereotype.Service
import ru.vtb.configuration.server.controller.dto.Arrow
import ru.vtb.configuration.server.controller.dto.GraphNode
import ru.vtb.configuration.server.controller.intf.PumlGeneratorController
import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.intf.PumlGeneratorRepository
import java.util.*

@Service
class PumlGeneratorControllerImpl(
    val pumlGeneratorRepository: PumlGeneratorRepository
) : PumlGeneratorController {

    override fun generatePumlByGraphId(graphId: String): String {
        val arrows = pumlGeneratorRepository.findByGraphId(graphId)
        return pumlFromArrows(arrows)
    }

    override fun generatePumlByTopic(topicId: String, directionEnum: DirectionEnum): String {
        val arrows: Set<Arrow<out GraphNode, out GraphNode>> = pumlGeneratorRepository.findByTopic(topicId)
        val arrowsCutten: Set<Arrow<out GraphNode, out GraphNode>> = cutArrows(arrows, topicId, directionEnum)
        return pumlFromArrows(arrowsCutten)
    }


    companion object {

        private val head = """@startuml
digraph dfd{
	node[shape=record]"""

        private val tail = """}
@enduml"""

        fun pumlFromArrows(arrows: Set<Arrow<out GraphNode, out GraphNode>>): String {
            val nodesStr = arrows
                .flatMap { listOf(it.from, it.to) }
                .union(arrows)
                .toSet()
                .joinToString(separator = "\n") { it.pamlUmlText() }

            val trimMargin = """$head
                |
                |$nodesStr
                |
                |$tail
            """.trimMargin()
            return trimMargin
        }

        fun filterNodeFunction(
            directionEnum: DirectionEnum,
            arrow: Arrow<out GraphNode, out GraphNode>
        ) = when (directionEnum) {
            DirectionEnum.IN -> arrow.from
            DirectionEnum.OUT -> arrow.to
        }

        fun cutArrows(
            arrows: Set<Arrow<out GraphNode, out GraphNode>>,
            nodeId: String,
            directionEnum: DirectionEnum,
            result: Set<Arrow<out GraphNode, out GraphNode>> = mutableSetOf()
        ): Set<Arrow<out GraphNode, out GraphNode>> {

            val arrowsByNode = arrows
                .filter { arrow -> filterNodeFunction(directionEnum, arrow).id == nodeId }

            val newResult = Optional.ofNullable(arrowsByNode)
                .map { it.plus(result).toSet() }
                .orElseGet { result }

            return if (newResult != result) {
                val tailArrow = arrows.filter { a -> !newResult.contains(a) }.toSet()
                arrowsByNode.flatMap { na ->
                    val node = filterNodeFunction(directionEnum.reverce(), na)
                    cutArrows(tailArrow, node.id, directionEnum, newResult)
                }.toSet()

            } else newResult

        }
    }


}


