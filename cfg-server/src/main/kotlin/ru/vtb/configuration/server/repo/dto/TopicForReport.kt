package ru.vtb.configuration.server.repo.dto

data class TopicForReport(
    val topicName: String,
    val cntPartition: Int,
    val cleanupPolicy: String,
    val retention: Long,
    val serviceSet: Set<ServiceForReport>
)
