package ru.vtb.configuration.server.repo.dto

data class ServiceForReport(
    val serviceName: String,
    val profileId: String,
    val reportDescription: String,
    val direction: String,
    val cn: String
)
