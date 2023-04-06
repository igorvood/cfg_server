package ru.vtb.configuration.server.rest.update

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.controller.move.IMoveDictServiceController

interface IUpdateDictServiceRest {

    fun moveDictService(
        id: String,
        profile: String,
        newProfile: String,
    ): Int
}

@RestController
class UpdateDictServiceRest(private val iMoveDictServiceController: IMoveDictServiceController) :
    IUpdateDictServiceRest {

    @Operation(summary = "Переименовать профиль. Возвращает кол-во проапдейченных записей.", tags = ["Служебные."])
    @PostMapping("/moveDictService", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun moveDictService(
        id: String,
        profile: String,
        newProfile: String,
    ): Int {
        return iMoveDictServiceController.renameProfile(id, profile, newProfile)

    }
}