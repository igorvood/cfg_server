package ru.vtb.jpaprocessor.generator.template

import ru.vtb.jpaprocessor.generator.model.OrIsNullField
import java.util.*

class FreeField(private val orIsNullfield: OrIsNullField) {
    val name: String
        get() = orIsNullfield.name()
    val type: String
        get() = orIsNullfield.type()
    val klass: FreeKlass
        get() = FreeKlass(orIsNullfield.betterClass())
    val getter: String
        get() = "get" + name.uppercase(Locale.getDefault())[0] + name.substring(1)
}