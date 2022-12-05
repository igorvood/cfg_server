package ru.vtb.configuration.server.controller.dto.tracer

sealed interface GraphNodeJson

data class TopicJson(
    val name: String,
) : GraphNodeJson

data class FlinkSrvJson(
    val name: String,
    val profileId: String
) : GraphNodeJson