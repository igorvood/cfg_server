package ru.vtb.configuration.server.controller.dto

sealed interface GraphNode : PumlGenerator {
    val alias: String
    val id: String
}

data class TopicPuml(
    val name: String,
    val topicOwnerId: String,
    val topicGroup: String,

) : GraphNode {
    override val alias: String
        get() = name.replace("-", "_")

    override val id: String
        get() = name

    override fun pamlUmlText(): String {
        val color =  "Green"// else "Red"
        return """$alias [label="$alias" shape=box color=$color];"""
    }

}

data class FlinkSrvPuml(val name: String, val profileId: String) : GraphNode {
    override val alias: String
        get() = replaceForPuml(name + "_" + profileId)

    override val id: String
        get() = "$name~$profileId"

    private val pumlProfile = replaceForPuml(profileId)

    private val pumlName = replaceForPuml(name)

    override fun pamlUmlText(): String {
//        """${d.serviceId} [label="{<f0> ${d.serviceId} |<f1> ${d.profileId}\n\n\n}" shape=Mrecord];"""

        return """${alias} [label="{<f0> ${pumlName} |<f1> ${pumlProfile}\n\n\n}" shape=Mrecord];"""


    }
}