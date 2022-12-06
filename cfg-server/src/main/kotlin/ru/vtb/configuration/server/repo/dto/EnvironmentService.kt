package ru.vtb.configuration.server.repo.dto

data class EnvironmentService(
    val flinkServiceProfile: FlinkServiceProfile,
    val body: String
)
