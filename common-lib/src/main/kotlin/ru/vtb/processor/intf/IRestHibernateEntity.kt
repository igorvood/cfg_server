package ru.vtb.processor.intf

import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import java.util.*

interface IRestHibernateEntity<IMMUTABLE, PK> {

    fun findById(id: PrimaryKeyWrapper<PK>): Optional<IMMUTABLE>
    fun findAll(): List<IMMUTABLE>

    fun save(data: IMMUTABLE): IMMUTABLE

    fun deleteById(id: PrimaryKeyWrapper<PK>)

    fun editEntity(primaryKey: PrimaryKeyWrapper<PK>, newData: IMMUTABLE): IMMUTABLE?
}