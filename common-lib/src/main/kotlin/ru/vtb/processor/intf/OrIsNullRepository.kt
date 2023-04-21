package ru.vtb.processor.intf

import javax.persistence.EntityManagerFactory

abstract class OrIsNullRepository<Filter : IFilterHibernateEntity, ENTITY>(
    private val emf: EntityManagerFactory,
    private val javaClazz: Class<ENTITY>
) {
    fun findByFilterOrIsNull(filter: Filter): List<ENTITY> {
        val query = emf.createEntityManager()
            .createQuery(filter.clean(), javaClazz)
        filter.params().forEach(query::setParameter)
        val resultList = query.resultList;
        return resultList
    }

}