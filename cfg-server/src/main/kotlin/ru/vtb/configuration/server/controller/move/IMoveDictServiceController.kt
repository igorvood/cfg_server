package ru.vtb.configuration.server.controller.move

import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.repo.move.IMoveDictServiceRepo

interface IMoveDictServiceController {
    fun renameProfile(
        serviceId: String,
        profile: String,
        newProfile: String,
    ): Int

}

@Controller
class MoveDictServiceController(val iMoveDictServiceRepo: IMoveDictServiceRepo) : IMoveDictServiceController {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun renameProfile(serviceId: String, profile: String, newProfile: String): Int {
        val listOf: List<(newServiceId: String, newProfile: String, serviceId: String, profile: String) -> Int> =
            listOf(
                iMoveDictServiceRepo::serviceNodeMove,
                iMoveDictServiceRepo::serviceGroupMove,
                iMoveDictServiceRepo::flinkPropValueMove,
                iMoveDictServiceRepo::abstractServiceMove,
                iMoveDictServiceRepo::srvArrowsMove,
                iMoveDictServiceRepo::placeHolderByServiceMove,
            )

        return listOf.sumOf { it(serviceId, newProfile, serviceId, profile) }
    }

}