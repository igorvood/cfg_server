package ru.vtb.configuration.server.example

interface ExampleProcedureRun {

    fun rundict_service_ins_trg(
        GRAPH_ID_PAR: String,
        service_id_PAR: String,
        profile_id_par: String,
        MAIN_CLASS_par: String
    ): Unit

}