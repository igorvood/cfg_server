package ru.vtb.configuration.server.example

import org.springframework.boot.CommandLineRunner

//@Service
class ExampleCommandLineRunner(
    private val ExampleProcedureRun: ExampleProcedureRun,

) : CommandLineRunner {
    override fun run(vararg args: String?) {
        try {
            ExampleProcedureRun.rundict_service_ins_trg(
                "test_graph_id",
                "test_service_id",
                "test_profile_id",
                "test_MainClass"
            )
        } catch (e: Throwable) {
            println(e.message)
        }


    }
}