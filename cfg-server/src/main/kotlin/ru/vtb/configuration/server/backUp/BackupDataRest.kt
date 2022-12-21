package ru.vtb.configuration.server.backUp

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.*
import ru.vtb.configuration.server.backUp.dto.SqlDto


@RestController
class BackupDataRest(val dataCollectService: DataCollectService) {

    @Operation(summary = "Импорт", tags = ["Импорт/экспорт"])
    @GetMapping("/importData")
    fun importData(
        @RequestBody sql: SqlDto,
    ) {
        dataCollectService.importData(listOf(), sql.sql)
    }


    @Operation(summary = "экспорт", tags = ["Импорт/экспорт"])
    @GetMapping("/exportData")
    fun exportData(): String {
        return dataCollectService.exportData(listOf())
    }

}