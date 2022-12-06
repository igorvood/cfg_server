package ru.vtb.configuration.server.controller

import org.springframework.stereotype.Service
import ru.vtb.configuration.server.controller.intf.ReportTopicController
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.repo.intf.ReportTopicRepository

@Service
class ReportTopicControllerImpl(
    val reportTopicRepository: ReportTopicRepository
) : ReportTopicController {
    override fun topicsByStand(standEnum: StandEnum): List<String> {
        return reportTopicRepository.topicsByStand(standEnum)

    }
    override fun usedTopics(): Set<String> {
        return reportTopicRepository.usedTopics()
    }

    override fun unUsedTopics(): Set<String> {
        return reportTopicRepository.unUsedTopics()
    }
}