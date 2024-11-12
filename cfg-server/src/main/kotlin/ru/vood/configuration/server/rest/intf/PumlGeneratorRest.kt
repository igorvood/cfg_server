package ru.vood.configuration.server.rest.intf

interface PumlGeneratorRest {

    fun plantUMLNew(graphId: String): String

}