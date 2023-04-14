package ru.vtb.processor.intf

interface IRestHibernateEntity<IMMUTABLE, PK> {
    fun findAll(): List<IMMUTABLE>

    fun save(data: IMMUTABLE): IMMUTABLE

    fun deleteById(id: PK)

    fun editEntity(primaryKey: PK,newData: IMMUTABLE): IMMUTABLE?
}