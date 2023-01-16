package ru.vtb.configuration.server.ui

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.backUp.dto.TableMeta

@RestController
class UiRest(private val uiController: UiController) {

    @Operation(summary = "Мета информация по таблицам", tags = ["UI"])
    @GetMapping("/tablesMeta")
    fun tablesMeta(): Set<TableMeta> {
        return uiController.tablesMeta()
    }
}