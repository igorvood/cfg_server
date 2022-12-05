package ru.vtb.configuration.server.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import ru.vtb.configuration.server.controller.PumlGeneratorControllerImpl.Companion.cutArrows
import ru.vtb.configuration.server.controller.PumlGeneratorControllerImpl.Companion.pumlFromArrows
import ru.vtb.configuration.server.controller.dto.Arrow
import ru.vtb.configuration.server.controller.dto.FlinkSrvPuml
import ru.vtb.configuration.server.controller.dto.GraphNode
import ru.vtb.configuration.server.controller.dto.TopicPuml
import ru.vtb.configuration.server.repo.dto.DirectionEnum
import ru.vtb.configuration.server.repo.intf.PumlGeneratorRepository
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class PumlGeneratorControllerImplTest {

    val pumlGeneratorRepository = mock(PumlGeneratorRepository::class.java)

    val pumlGeneratorControllerImpl = PumlGeneratorControllerImpl(pumlGeneratorRepository)

    val arrows: Set<Arrow<out GraphNode, out GraphNode>> = setOf(
        Arrow(topicOf("t1"), flinkOf("s1")),
        Arrow(flinkOf("s1"), topicOf("tCircle")),
        Arrow(topicOf("tCircle"), flinkOf("s1")),

        Arrow(flinkOf("s1"), topicOf("t2")),
        Arrow(flinkOf("s1"), topicOf("t3")),

        Arrow(topicOf("t3"), flinkOf("s2")),
        Arrow(topicOf("t3"), flinkOf("s_end")),
        Arrow(topicOf("t2"), flinkOf("s11")),
        Arrow(flinkOf("s11"), topicOf("t11")),

        Arrow(flinkOf("s11"), topicOf("t5")),

        Arrow(topicOf("t11"), flinkOf("s2")),

        Arrow(flinkOf("s2"), topicOf("t4")),
        Arrow(flinkOf("s2"), topicOf("t5")),
    )

    @Test
    fun pumlFromArrowsCut() {
        val pumlFromArrows = pumlFromArrows(arrows)
        println(pumlFromArrows)
    }

    @Test
    fun pumlFromArrows() {
        val pumlFromArrows = cutArrows(arrows, "t4", DirectionEnum.OUT)
        val pumlFromArrows1 = pumlFromArrows(pumlFromArrows)
        println(pumlFromArrows1)
    }


}

fun topicOf(name: String): TopicPuml = TopicPuml(name, true, "p", "c")

fun flinkOf(name: String): FlinkSrvPuml = FlinkSrvPuml(name, "profile")