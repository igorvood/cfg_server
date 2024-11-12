package ru.vood.configuration.server.repo.intf

import ru.vood.configuration.server.repo.dto.GroupServiceDto

interface DictGroupRepository {

    fun groupList(): Set<GroupServiceDto>
}