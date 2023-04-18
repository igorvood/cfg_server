package ru.vtb.configuration.server.delete

import org.springframework.stereotype.Service
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.genRest.dictabstractgraphnodeentity.DictAbstractGraphNodeEntityFilter
import ru.vtb.processor.intf.OrIsNullRepository
import javax.persistence.EntityManagerFactory

@Service
class asdasd(
    emf: EntityManagerFactory
) : OrIsNullRepository<DictAbstractGraphNodeEntityFilter, DictAbstractGraphNodeEntity>(emf, DictAbstractGraphNodeEntity::class.java)