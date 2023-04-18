package ru.vtb.configuration.server.delete

import org.springframework.stereotype.Service
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityFilter
import ru.vtb.processor.intf.OrIsNullRepository
import javax.persistence.EntityManagerFactory

@Service
class asdasd(
    val emf: EntityManagerFactory
) : OrIsNullRepository<DictAbstractGraphNodeEntityFilter, DictAbstractGraphNodeEntity> {

    val java: Class<DictAbstractGraphNodeEntity> = DictAbstractGraphNodeEntity::class.java

    override fun findByFilterOrIsNull(filter: DictAbstractGraphNodeEntityFilter): List<DictAbstractGraphNodeEntity> {

        val query = emf.createEntityManager()
            .createQuery(filter.clean(), java)

        filter.params().forEach(query::setParameter)

        val resultList = query.resultList;

        return resultList
    }
}