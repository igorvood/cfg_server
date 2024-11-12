package ru.vood.configuration.server.shceduller

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.vood.configuration.server.repo.DictServiceGroupRepository


@Service
class ServiceGroupAutomationFiller(
    private val dictServiceGroupRepository: DictServiceGroupRepository,

    ) {

    @Scheduled(fixedDelay = 300000)
    fun scheduleFixedDelayTask() {
        dictServiceGroupRepository.fillDefaultTracerGroup()
    }

}