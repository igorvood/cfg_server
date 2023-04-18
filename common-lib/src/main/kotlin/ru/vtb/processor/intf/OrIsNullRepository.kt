package ru.vtb.processor.intf

interface OrIsNullRepository<Filter:IFilterHibernateEntity, ENTITY> {

    fun findByFilterOrIsNull(filter: Filter): List<ENTITY>
}