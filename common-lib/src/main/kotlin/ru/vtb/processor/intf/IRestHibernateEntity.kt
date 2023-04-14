package ru.vtb.processor.intf

import java.util.*

interface IRestHibernateEntity<IMMUTABLE, PK> {

    fun findById(id: PK): Optional<IMMUTABLE>
    fun findAll(): List<IMMUTABLE>

    fun save(data: IMMUTABLE): IMMUTABLE

    fun deleteById(id: PK)

    fun editEntity(primaryKey: PK, newData: IMMUTABLE): IMMUTABLE?
}