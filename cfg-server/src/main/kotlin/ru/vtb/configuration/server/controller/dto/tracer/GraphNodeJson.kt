package ru.vtb.configuration.server.controller.dto.tracer

sealed interface GraphNodeJson

data class TopicJson(

    val name: String,
    val type: String = "TopicJson",
) : GraphNodeJson

data class FlinkSrvJson(
    val name: String,
    val profileId: String,
    val type: String = "FlinkSrvJson",
) : GraphNodeJson