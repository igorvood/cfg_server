package ru.vtb.configuration.server.rest.update

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.controller.move.IMoveDictServiceController

interface IUpdateDictServiceRest {
    @Operation(summary = "Обновить запись в таблица сервисов", tags = ["Служебные."])
    @GetMapping("/graphList", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun moveDictService(        id: String,
                                profile: String,
                                newProfile: String,
    )
}

@RestController
class UpdateDictServiceRest(private val iMoveDictServiceController: IMoveDictServiceController) :
    IUpdateDictServiceRest {

    @Operation(summary = "переименовать профиль", tags = ["Служебные."])
    @PostMapping("/moveDictService", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun moveDictService(
        id: String,
        profile: String,
        newProfile: String,
        ){
        iMoveDictServiceController.renameProfile(id,profile,newProfile)

    }
}