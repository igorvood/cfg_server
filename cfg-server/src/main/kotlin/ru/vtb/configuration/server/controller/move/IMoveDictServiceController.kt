package ru.vtb.configuration.server.controller.move

import org.springframework.stereotype.Controller
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.repo.move.IMoveDictServiceRepo

interface IMoveDictServiceController {
    fun renameProfile(id: String,
                      profile: String,
                      newProfile: String,): Int

}

@Controller
class MoveDictServiceController(val iMoveDictServiceRepo: IMoveDictServiceRepo) : IMoveDictServiceController {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun renameProfile(id: String, profile: String, newProfile: String): Int {

        return iMoveDictServiceRepo.serviceNodeMove(id, newProfile, id, profile) +
                iMoveDictServiceRepo.serviceGroupMove(id, newProfile, id, profile) +
                iMoveDictServiceRepo.flinkPropValueMove(id, newProfile, id, profile) +
                iMoveDictServiceRepo.abstractServiceMove(id, newProfile, id, profile) +
                iMoveDictServiceRepo.srvArrowsMove(id, newProfile, id, profile) +
                iMoveDictServiceRepo.placeHolderByServiceMove(id, newProfile, id, profile)
    }

}