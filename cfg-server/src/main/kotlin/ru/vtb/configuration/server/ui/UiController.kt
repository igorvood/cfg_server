package ru.vtb.configuration.server.ui

import org.springframework.stereotype.Controller
import ru.vtb.configuration.server.backUp.DataBackUpRepository
import ru.vtb.configuration.server.backUp.dto.TableMeta


@Controller
class UiController(
    private val dataBackUpRepository: DataBackUpRepository
) {

    fun tablesMeta(): Set<TableMeta> {
        return dataBackUpRepository.metaDataByTable().toSet()
    }
}