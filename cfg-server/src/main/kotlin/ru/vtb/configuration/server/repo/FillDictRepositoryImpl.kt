package ru.vtb.configuration.server.repo

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.PreparedStatementCallback
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.dto.GraphFlinkServiceProfile
import ru.vtb.configuration.server.repo.dto.PropertyDto
import ru.vtb.configuration.server.repo.intf.FillDictRepository
import java.sql.CallableStatement

@Repository
class FillDictRepositoryImpl(
    private val jdbcTemplate: JdbcOperations
) : FillDictRepository {

    @Transactional(propagation = Propagation.MANDATORY)
    override fun dictServiceInsert(graphFlinkServiceProfile: GraphFlinkServiceProfile) {
        jdbcTemplate.execute(PreparedStatementCreator { con ->
            val cs: CallableStatement = con.prepareCall(
                """select dict_service_ins_trg(?, ?, ?, ?)"""
            )
            cs.setString(1, graphFlinkServiceProfile.graphId)
            cs.setString(2, graphFlinkServiceProfile.flinkServiceProfile.serviceId.id)
            cs.setString(3, graphFlinkServiceProfile.flinkServiceProfile.profileId)
            cs.setString(4, graphFlinkServiceProfile.flinkServiceProfile.serviceId.mainClass)
            cs
        }, PreparedStatementCallback { ps ->
            ps.execute()
            1
        })
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun dictServiceDelete(serviceId: String, profileId: String): Int {
        return jdbcTemplate.update(
            "delete from dict_abstract_graph_node where node_id in  (select id from dict_service_node where service_id = ? and profile_id = ?)",
            serviceId,
            profileId
        )
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun dictTopicInsert(graphId: String, topicName: String, owner: String) {
        jdbcTemplate.execute(PreparedStatementCreator { con ->
            val cs: CallableStatement = con.prepareCall(
                """select dict_topic_ins_trg(?, ?, ?)"""
            )
            cs.setString(1, graphId)
            cs.setString(2, topicName)
            cs.setString(3, owner)

            cs
        }, PreparedStatementCallback { ps ->
            ps.execute()
            1
        })
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun dictTopicDelete(topicName: String): Int {
        return jdbcTemplate.update(
            "delete from dict_abstract_graph_node where node_id in  (select id from dict_topic_node where id = ?)",
            topicName
        )
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun dictArrowInsert(
        directionEnum: DirectionEnum,
        graphId: String,
        serviceId: String,
        profileId: String,
        topicName: String,
        propertyKey: String,
        kafkaPropertyGroup: String,
    ) {
        val beginNode = if (directionEnum == DirectionEnum.IN) {
            topicName
        } else "$serviceId~$profileId"

        val endNode = if (directionEnum == DirectionEnum.IN) {
            "$serviceId~$profileId"
        } else topicName


        jdbcTemplate.execute(PreparedStatementCreator { con ->
            val cs: CallableStatement = con.prepareCall(
                """
                insert into DICT_ARROW(GRAPH_ID, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, PROPERTY_KEY, kafka_grp_prop)
                values (?, ?, ?, ?, ?, ?, ?)
                """
            )
            cs.setString(1, graphId)
            cs.setString(2, directionEnum.nodeTypeBegin)
            cs.setString(3, beginNode)
            cs.setString(4, directionEnum.nodeTypeEnd)
            cs.setString(5, endNode)
            cs.setString(6, propertyKey)
            cs.setString(7, kafkaPropertyGroup)

            cs
        }, PreparedStatementCallback { ps ->
            ps.execute()
            1
        })
    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun dictFlinkPropertyInsert(
        serviceId: String,
        profileId: String,
        propertyDto: PropertyDto,
    ) {
        jdbcTemplate.execute(PreparedStatementCreator { con ->
            val cs: CallableStatement = con.prepareCall(
                """
                insert into DICT_FLINK_PROP_VALUE(SERVICE_ID, PROFILE_ID, PROP_ID, PROP_VALUE)
                values (?, ?, ?, ?)
                """
            )
            cs.setString(1, serviceId)
            cs.setString(2, profileId)
            cs.setString(3, propertyDto.name)
            cs.setString(4, propertyDto.value)
            cs
        }, PreparedStatementCallback { ps ->
            ps.execute()
            1
        })

    }

    @Transactional(propagation = Propagation.MANDATORY)
    override fun flinkPropertyDelete(serviceId: String, profileId: String, propId: String) {
        jdbcTemplate.update(
            "delete from DICT_FLINK_PROP_VALUE where service_id = ? and profile_id = ? and prop_id = ?;",
            serviceId,
            profileId,
            propId
        )
    }
}