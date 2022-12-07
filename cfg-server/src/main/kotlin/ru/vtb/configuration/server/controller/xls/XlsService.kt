package ru.vtb.configuration.server.controller.xls

interface XlsService<T> {

    fun repTopics(data: Collection<T>)

}