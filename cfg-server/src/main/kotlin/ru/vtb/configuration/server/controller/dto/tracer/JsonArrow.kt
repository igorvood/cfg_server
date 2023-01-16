package ru.vtb.configuration.server.controller.dto.tracer

data class JsonArrow(
    val from: GraphNodeJson,
    val to: GraphNodeJson,
) {

    init {
        val b = when (from) {
            is TopicJson -> when (to) {
                is FlinkSrvJson -> true
                is TopicJson -> false
            }
            is FlinkSrvJson -> when (to) {
                is TopicJson -> true
                is FlinkSrvJson -> false
            }
        }
        require(b) { "unable to create JsonArrow, values from and have to different type, current values is:\nfrom=$from\nto=$to" }
    }
//    companion object {
//        fun of(from: GraphNodeJson, to: GraphNodeJson): JsonArrow {
//            val pairFrom = when (from) {
//                is TopicJson -> null to from
//                is FlinkSrvJson -> from to null
//            }
//            val pairTo = when (to) {
//                is TopicJson -> null to to
//                is FlinkSrvJson -> to to null
//            }
//            return JsonArrow(pairFrom.first, pairFrom.second, pairTo.first, pairTo.second)
//        }
//    }
}