package ru.vtb.configuration.server.rest

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.controller.intf.ConfigurationGeneratorController
import ru.vtb.configuration.server.controller.dto.EnvironmentService
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.rest.intf.ConfigurationGeneratorRest

@RestController
class ConfigurationGeneratorRestImpl(
    val configurationGeneratorController: ConfigurationGeneratorController,
) : ConfigurationGeneratorRest {

    @Operation(summary = "Настройки по профилю сервиса ", tags = ["Генерация"])
    @GetMapping("/envBody")
    override fun generateEnvBody(
        @RequestParam
        serviceId: String,
        @RequestParam
        profileId: String,
        @RequestParam
        stand: StandEnum
    ): String {
        return configurationGeneratorController.generateEnvBody(serviceId, profileId, stand)
    }

    @Operation(summary = "Настройки сервиса, по всем его профилям", tags = ["Генерация"])
    @GetMapping("/allProfilesEnvBodies", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun allServiceProfileByStand(
        @RequestParam
        serviceId: String,
        @RequestParam
        stand: StandEnum
    ): List<EnvironmentService> {
        return configurationGeneratorController.generateAllServiceProfile(serviceId, stand)
    }

    @Operation(summary = "Zip файл со всеми конфигурациями сервиса по всем не локальным стендам", tags = ["Генерация"])
    @GetMapping(
        "/envirimentsZip", produces = [MediaType.APPLICATION_PDF_VALUE]
    )
    @ResponseBody
    override fun environmentZip(
        @RequestParam serviceId: String
    ): ByteArray {
        return configurationGeneratorController.environmentZip(serviceId, true)
    }

    @Operation(summary = "Zip файл со всеми конфигурациями сервиса по всем не локальным стендам", tags = ["Генерация"])
    @GetMapping(
        "/envirimentsZipAll", produces = [MediaType.APPLICATION_PDF_VALUE]
    )
    @ResponseBody
    override fun environmentZipAll(
        @RequestParam serviceId: String
    ): ByteArray {
        return configurationGeneratorController.environmentZip(serviceId, false)
    }

}