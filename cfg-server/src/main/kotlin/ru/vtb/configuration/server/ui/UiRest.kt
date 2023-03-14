package ru.vtb.configuration.server.ui

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.backUp.dto.TableMeta
import ru.vtb.configuration.server.ui.controler.EditableTableDataDto
import ru.vtb.configuration.server.ui.controler.TableMetaController
import ru.vtb.configuration.server.ui.controler.TableUiDto

@RestController
@CrossOrigin
class UiRest(
    private val uiController: UiController,
    private val tableMetaController: TableMetaController
) {

    @Operation(summary = "Мета информация по таблицам", tags = ["UI"])
    @GetMapping("/tablesMeta")
    fun tablesMeta(): Set<TableMeta> {
        return uiController.tablesMeta()
    }

    @Operation(summary = "Список таблиц", tags = ["UI"])
    @GetMapping("/tablesList")
    fun tablesList(): Set<TableUiDto> {
        return tableMetaController.tablesList()
    }

    @Operation(summary = "Данные таблицы", tags = ["UI"])
    @GetMapping("/tableData/{tableName}")
    fun tableData(@PathVariable tableName: String): EditableTableDataDto {
        return tableMetaController.tableData(tableName)
    }

}