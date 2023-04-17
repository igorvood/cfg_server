package ru.vtb.processor.intf

import ru.vtb.processor.wrapper.PrimaryKeyWrapper
import ru.vtb.processor.wrapper.RestEditEntityDto
import java.util.*

interface IRestHibernateEntity<IMMUTABLE, PK> {

    fun findById(id: PrimaryKeyWrapper<PK>): Optional<IMMUTABLE>
    fun findAll(): List<IMMUTABLE>

    fun save(data: IMMUTABLE): IMMUTABLE

    fun deleteById(id: PrimaryKeyWrapper<PK>)

    fun editEntity(editData: RestEditEntityDto<PK, IMMUTABLE>): IMMUTABLE?
}