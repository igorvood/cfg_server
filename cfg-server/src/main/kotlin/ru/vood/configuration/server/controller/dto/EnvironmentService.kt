package ru.vood.configuration.server.controller.dto

import ru.vood.configuration.server.repo.dto.FlinkServiceProfile

data class EnvironmentService(
    val flinkServiceProfile: FlinkServiceProfile,
    val body: String
)
