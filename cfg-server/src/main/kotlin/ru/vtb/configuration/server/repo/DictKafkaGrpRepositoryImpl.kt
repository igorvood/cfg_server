package ru.vtb.configuration.server.repo

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.controller.dto.Direction
import ru.vtb.configuration.server.controller.dto.KafkaPropertyGrp
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.repo.intf.DictKafkaGrpRepository

@Repository
class DictKafkaGrpRepositoryImpl(
    private val jdbcTemplate: JdbcOperations
) : DictKafkaGrpRepository {

    override fun kafkaPropertyGrpList(): Set<KafkaPropertyGrp> {
        return jdbcTemplate.query("""select id, type_read, description from dict_kafka_property_grp""") { rs, _ ->
            KafkaPropertyGrp(
                id = rs.getString(1),
                typeRead = Direction.valueOf(rs.getString(2)),
                description = rs.getString(3)
            )
        }.toSet()

    }

    override fun kafkaPropertyGrp(grpId: String, direction: Direction): Set<PropertyDto> {
        return jdbcTemplate.query(
            """select prop_id, prop_value from dict_kafka_prop_value
                                        where grp_id = ? and type_prop = ?""",
            { rs, _ ->
                PropertyDto(rs.getString(1), rs.getString(2))
            }, grpId, direction.name
        ).toSet()
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun kafkaPropertyGrpDelete(grpId: String, direction: Direction): Int {
        return jdbcTemplate.update(
            """delete from dict_kafka_prop_value where  grp_id = ? and type_prop = ?""",
            grpId,
            direction.name
        )
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun kafkaPropertyEdit(grpId: String, direction: Direction, propertyRestDto: PropertyDto) {
        jdbcTemplate.update(
            """update dict_kafka_prop_value pv set prop_value = ? where grp_id = ? and type_prop = ? and prop_id = ? """,
            propertyRestDto.name, grpId, direction.name, propertyRestDto.value
        )
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun kafkaPropertyAdd(grpId: String, direction: Direction, propertyRestDto: PropertyDto) {
        jdbcTemplate.update(
            """insert into dict_kafka_prop_value(grp_id, type_prop, prop_id, prop_value) VALUES (?, ?, ?, ?) """,
            grpId, direction.name, propertyRestDto.name, propertyRestDto.value
        )
    }


    @Transactional(propagation = Propagation.MANDATORY)
    override fun kafkaPropertyGrpAdd(grpId: String, direction: Direction, description: String) {
        jdbcTemplate.update(
            """insert into dict_kafka_property_grp(id, type_read, description) VALUES (?, ?, ?) """,
            grpId, direction.name, description
        )
    }
}