package ru.vood.configuration.server.repo

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.configuration.server.repo.dto.GroupServiceDto
import ru.vood.configuration.server.repo.intf.DictGroupRepository

@Repository
class DictGroupRepositoryImpl(
    private val jdbcTemplate: JdbcOperations
) : DictGroupRepository {
    override fun groupList(): Set<GroupServiceDto> {
        return jdbcTemplate.query("""select id, description from dict_group""") { rs, _ ->
            GroupServiceDto(
                id = rs.getString(1),
                description = rs.getString(2)
            )
        }.toSet()
    }
}