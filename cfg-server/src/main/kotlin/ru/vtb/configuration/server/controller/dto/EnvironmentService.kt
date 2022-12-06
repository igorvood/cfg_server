package ru.vtb.configuration.server.controller.dto

import ru.vtb.configuration.server.repo.dto.FlinkServiceProfile

data class EnvironmentService(
    val flinkServiceProfile: FlinkServiceProfile,
    val body: String
)
