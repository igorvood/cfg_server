package ru.vtb.configuration.server.controller.dto.tracer

data class JsonArrow(
    val fromSrv: FlinkSrvJson?,
    val fromTopic: TopicJson?,

    val toSrv: FlinkSrvJson?,
    val toTopic: TopicJson?,

    ) {
    companion object {
        fun of(from: GraphNodeJson, to: GraphNodeJson): JsonArrow {
            val pairFrom = when (from) {
                is TopicJson -> null to from
                is FlinkSrvJson -> from to null
            }
            val pairTo = when (to) {
                is TopicJson -> null to to
                is FlinkSrvJson -> to to null
            }
            return JsonArrow(pairFrom.first, pairFrom.second, pairTo.first, pairTo.second)
        }
    }
}