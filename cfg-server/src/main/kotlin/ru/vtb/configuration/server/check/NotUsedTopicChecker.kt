package ru.vtb.configuration.server.check

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vtb.configuration.server.repo.intf.ReportTopicRepository

@Service
class NotUsedTopicChecker(
    val reportTopicRepository: ReportTopicRepository
) : CheckService {

    private val logger = LoggerFactory.getLogger(NotUsedTopicChecker::class.java)
    override fun check() {
        reportTopicRepository.unUsedTopics().sorted().forEach { logger.warn("'$it' found unused topic ") }
    }
}