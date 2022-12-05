package ru.vtb.configuration.server.controller.dto

data class Arrow<F : GraphNode, T : GraphNode>(val from: F, val to: T) : PumlGenerator {

    private val nameGrp = when (from) {
        is TopicPuml -> from.consumerGrp
        is FlinkSrvPuml -> when (to) {
            is TopicPuml -> to.producerGrp
            else -> throw IllegalArgumentException("Не поддерживаемый тип  " + to.javaClass)
        }

        else -> throw IllegalArgumentException("Не поддерживаемый тип  " + from.javaClass)
    }


    override fun pamlUmlText(): String = """${from.alias} -> ${to.alias}""" + "[label=\"${nameGrp}\"]"
}