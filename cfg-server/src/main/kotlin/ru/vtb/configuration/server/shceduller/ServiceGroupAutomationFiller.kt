package ru.vtb.configuration.server.shceduller

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.vtb.configuration.server.repo.DictServiceGroupRepository


@Service
class ServiceGroupAutomationFiller(private val dictServiceGroupRepository: DictServiceGroupRepository,

) {

    @Scheduled(fixedDelay = 300000)
    fun scheduleFixedDelayTask() {
        dictServiceGroupRepository.fillDefaultTracerGroup()
    }

}