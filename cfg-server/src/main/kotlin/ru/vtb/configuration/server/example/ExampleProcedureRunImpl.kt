package ru.vtb.configuration.server.example

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCallback
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Repository
import ru.vtb.configuration.server.dataEntity.repo.generated.DictTopicOwnerEntityImpl
import java.sql.CallableStatement


@Repository
class ExampleProcedureRunImpl(
    private val jdbcTemplate: JdbcTemplate,
    private val DictTopicOwnerEntityImpl: DictTopicOwnerEntityImpl
    ) : ExampleProcedureRun {

    override fun rundict_service_ins_trg(
        GRAPH_ID_PAR: String,
        service_id_PAR: String,
        profile_id_par: String,
        MAIN_CLASS_par: String
    ) {

        jdbcTemplate.execute(PreparedStatementCreator { con ->
            val cs: CallableStatement = con.prepareCall("""{CALL DICT_SERVICE_INS_trg(?, ?, ?, ?)}""")
            cs.setString(1, GRAPH_ID_PAR)
            cs.setString(2, service_id_PAR)
            cs.setString(3, profile_id_par)
            cs.setString(4, MAIN_CLASS_par)
            cs
        }, PreparedStatementCallback { ps ->
            ps.execute()
            1
        })

    }
}