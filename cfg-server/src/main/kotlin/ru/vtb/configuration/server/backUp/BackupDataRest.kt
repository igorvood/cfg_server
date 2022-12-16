package ru.vtb.configuration.server.backUp

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*


@RestController
class BackupDataRest(val dataCollectService: DataCollectService) {

    @Operation(summary = "Импорт", tags = ["Импорт/экспорт"])
    @GetMapping("/importData")
    fun importData(
        @RequestBody sql: String,
    ) {
        dataCollectService.importData(listOf(), sql)
    }


    @Operation(summary = "экспорт", tags = ["Импорт/экспорт"])
    @GetMapping("/exportData")
    fun exportData(): String {
        return dataCollectService.exportData(listOf())
    }

}