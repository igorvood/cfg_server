package ru.vtb.configuration.server.repo

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

import ru.vtb.configuration.server.controller.dto.Arrow
import ru.vtb.configuration.server.controller.dto.FlinkSrvPuml
import ru.vtb.configuration.server.controller.dto.GraphNode
import ru.vtb.configuration.server.controller.dto.TopicPuml
import ru.vtb.configuration.server.repo.dto.NodeType
import ru.vtb.configuration.server.repo.intf.PumlGeneratorRepository
import java.sql.ResultSet

@Repository
class PumlGeneratorRepositoryImpl(
    private val jdbcTemplate: JdbcTemplate
) : PumlGeneratorRepository {

    private val arrowsFunction: (rs: ResultSet, rowNum: Int) -> Arrow<out GraphNode, out GraphNode>? = { rs, _ ->
        when (NodeType.valueOf(rs.getString(1))) {
            NodeType.flink_srv -> Arrow(findService(rs.getString(2)), findTopic(rs.getString(4), rs.getString(5)))
            NodeType.topic -> Arrow(findTopic(rs.getString(2), rs.getString(5)), findService(rs.getString(4)))
        }

    }

    override fun findByGraphId(graphId: String): Set<Arrow<out GraphNode, out GraphNode>> =
        jdbcTemplate.query(
            """
            select BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop 
            from DICT_ARROW
            where GRAPH_ID = ?
            """,
            arrowsFunction, graphId
        ).toSet()

    override fun findByTopic(topicId: String): Set<Arrow<out GraphNode, out GraphNode>> {
        return jdbcTemplate.query(
            """
                select BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID 
                from DICT_ARROW
                where graph_id = (select distinct graph_id from dict_arrow 
                                    where BEG_NODE_ID = ? or END_NODE_ID = ?
                                  ) 
                """,
            arrowsFunction, topicId, topicId
        ).toSet()
    }

    override fun findByGroupId(groupId: String): Set<Arrow<out GraphNode, out GraphNode>> {
        return jdbcTemplate.query(
            """
                select BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop
                from rep_arrow_by_grp
                where group_id = ? 
                """,
            arrowsFunction, groupId
        ).toSet()
    }

    private fun findTopic(topicId: String, topicGroup: String): TopicPuml {
        val queryForObject = jdbcTemplate.queryForObject(
            """select ID, topic_owner_id from dict_topic_node
                    where ID = ?
        """, { rs, _ ->
                TopicPuml(
                    rs.getString(1), rs.getString(2), topicGroup
                )
            }, topicId
        )
        return queryForObject!!
    }

    private fun findService(serviceId: String): FlinkSrvPuml {
        val queryForObject = jdbcTemplate.query(
            """select service_id, profile_id, report_description
                    from dict_service_node
                    where ID = ?
        """, { rs, _ ->
                FlinkSrvPuml(rs.getString(1), rs.getString(2), rs.getString(3))
            }, serviceId
        )
        check(queryForObject.size == 1){"Unable to find service $serviceId "}
        return queryForObject[0]
    }


}