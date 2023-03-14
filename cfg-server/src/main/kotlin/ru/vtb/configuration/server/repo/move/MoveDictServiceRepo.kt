package ru.vtb.configuration.server.repo.move

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Repository
class MoveDictServiceRepo(
    private val jdbcOperations: JdbcOperations
) : IMoveDictServiceRepo {

    @Transactional(propagation = Propagation.MANDATORY)
    override fun srvArrowsMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ) = jdbcOperations.update(
        """update dict_arrow dsg set beg_node_id = ? where beg_node_id = ? and beg_node_type = 'flink_srv' """,

        "$newId~$newProfile",
        "$id~$profile",
    ) + jdbcOperations.update(
        """update dict_arrow dsg set end_node_id = ? where end_node_id = ? and end_node_type = 'flink_srv'""",

        "$newId~$newProfile",
        "$id~$profile",
    )


    @Transactional(propagation = Propagation.MANDATORY)
    override fun abstractServiceMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ) = jdbcOperations.update(
        """update dict_abstract_graph_node dsg set node_id =? where node_id = ? and node_type = 'flink_srv' """,

        "$newId~$newProfile",
        "$id~$profile",
    )

    @Transactional(propagation = Propagation.MANDATORY)
    override fun flinkPropValueMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ) = jdbcOperations.update(
        """update dict_flink_prop_value dsg set service_id =?, profile_id = ? where service_id =? and profile_id =? """,
        newId,
        newProfile,
        id,
        profile,
    )

    @Transactional(propagation = Propagation.MANDATORY)
    override fun serviceGroupMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ) = jdbcOperations.update(
        """update dict_service_group dsg set service_id =?, profile_id = ? where service_id =? and profile_id =? """,
        newId,
        newProfile,
        id,
        profile,
    )

    @Transactional(propagation = Propagation.MANDATORY)
    override fun serviceNodeMove(
        newId: String,
        newProfile: String,
        id: String,
        profile: String
    ) = jdbcOperations.update(
        """update dict_service_node dsn set service_id =? , profile_id = ? where service_id =? and profile_id =? """,
        newId,
        newProfile,
        id,
        profile,
    )

    @Transactional(propagation = Propagation.MANDATORY)
    override fun placeHolderByServiceMove(newId: String, newProfile: String, id: String, profile: String): Int =
        jdbcOperations.update(
            """update dict_place_holder_by_service dsn set service_id =? , profile_id = ? where service_id =? and profile_id =? """,
            newId,
            newProfile,
            id,
            profile,
        )
}