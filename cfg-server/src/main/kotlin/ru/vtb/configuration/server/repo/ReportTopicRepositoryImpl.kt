package ru.vtb.configuration.server.repo

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.stereotype.Repository
import ru.vtb.configuration.server.repo.dto.ServiceForReport
import ru.vtb.configuration.server.repo.dto.StandEnum
import ru.vtb.configuration.server.repo.dto.TopicForReport
import ru.vtb.configuration.server.repo.intf.ReportTopicRepository
import java.sql.CallableStatement
import java.sql.ResultSet

@Repository
class ReportTopicRepositoryImpl(
    private val jdbcTemplate: JdbcOperations
) : ReportTopicRepository {

    override fun topicsByStand(standEnum: StandEnum): List<String> {
        return jdbcTemplate.query(
            """select TOPIC_NAME 
                                    from REP_TOPIC_NAME_BY_STAND
                                    where is_used = 1 and STAND = ?""",
            { rs, _ -> rs.getString(1) }, standEnum.name
        )
    }

    override fun usedTopics(): Set<String> {
        return usabilityTopic(1)
    }

    override fun unUsedTopics(): Set<String> {
        return usabilityTopic(0)
    }

    private fun usabilityTopic(isUsed: Int) = jdbcTemplate.query(
        """select TOPIC_ID 
                                        from rep_topic_name_by_stand
                                        where is_used = ?""", { rs, _ -> rs.getString(1) }, isUsed
    )
        .toSet()


    override fun repTopics(groupId: String, stand: StandEnum): Set<TopicForReport> {
        val query = jdbcTemplate.query(
            PreparedStatementCreator { con ->
                val cs: CallableStatement =
                    con.prepareCall(
                        """select topic_name,
                                                  cleanup_policy,
                                                   retention,
                                                   cnt_partition, 
                                                   service_id,
                                                   profile_id,
                                                   srv_report_description,
                                                   dirrection,
                                                   cn
                                                   from rep_Topics where group_id = ? and stand = ?"""
                    )
                cs.setString(1, groupId)
                cs.setString(2, stand.name)
                cs
            },
            ResultSetExtractor { rs: ResultSet ->
                val res = mutableMapOf<TopicLocal, MutableSet<ServiceForReport>>()
                while (rs.next()) {
                    val mayBeNeTopic = TopicLocal(
                        topicName = rs.getString(1),
                        cleanupPolicy = rs.getString(2),
                        retention = rs.getLong(3),
                        cntPartition = rs.getInt(4),
                    )
                    val setSrv = res.computeIfAbsent(mayBeNeTopic) { mutableSetOf() }
                    setSrv.add(
                        ServiceForReport(
                            serviceName = rs.getString(5),
                            profileId = rs.getString(6),
                            reportDescription = rs.getString(7),
                            direction = rs.getString(8),
                            cn = rs.getString(9),
                        )
                    )
                }

                res.entries
                    .map {
                        val topic = it.key
                        val serviceSet = it.value
                        TopicForReport(
                            topic.topicName,
                            topic.cntPartition,
                            topic.cleanupPolicy,
                            topic.retention,
                            serviceSet
                        )

                    }.toSet()

            }
        )
        return query ?: setOf()
    }

    private data class TopicLocal(
        val topicName: String,
        val cleanupPolicy: String,
        val retention: Long,
        val cntPartition: Int
    )

}