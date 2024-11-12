package ru.vood.configuration.server.ui

import org.springframework.stereotype.Controller
import ru.vood.configuration.server.backUp.DataBackUpRepository
import ru.vood.configuration.server.backUp.dto.TableMeta


@Controller
class UiController(
    private val dataBackUpRepository: DataBackUpRepository
) {

    fun tablesMeta(): Set<TableMeta> {
        return dataBackUpRepository.metaDataByTable().toSet()
    }
}