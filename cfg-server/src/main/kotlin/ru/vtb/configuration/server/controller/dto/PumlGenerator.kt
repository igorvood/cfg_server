package ru.vtb.configuration.server.controller.dto

interface PumlGenerator {

    fun pamlUmlText(): String

    fun replaceForPuml(someStr: String): String = someStr
        .replace("-", "_")
        .replace("~", "_")

}
