package ru.vtb.configuration.server.repo.intf

import ru.vtb.configuration.server.repo.dto.GroupServiceDto

interface DictGroupRepository {

    fun groupList(): Set<GroupServiceDto>
}