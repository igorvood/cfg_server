package ru.vtb.jpaprocessor.generator.template

import ru.vtb.jpaprocessor.generator.model.OrIsNullSearchMethod

class FreeMethod(private val method: OrIsNullSearchMethod?) {
    val filter: FreeKlass
        get() = FreeKlass(method!!.filter())
    val entity: FreeKlass
        get() = FreeKlass(method!!.entity())
    val name: String
        get() = method!!.name()
    val query: String
        get() = method!!.query()
}