package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.controller.dto.Arrow
import ru.vtb.configuration.server.controller.dto.GraphNode

interface PumlGeneratorRepository {

    fun findByGraphId(graphId: String): Set<Arrow<out GraphNode, out GraphNode>>

    @Deprecated("Не используется, Удалить")
    fun findByTopic(topicId: String): Set<Arrow<out GraphNode, out GraphNode>>

    fun findByGroupId(groupId: String): Set<Arrow<out GraphNode, out GraphNode>>
}