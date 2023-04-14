package ru.vtb.configuration.server.delete

import org.springframework.data.jpa.repository.JpaRepository
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.processor.annotation.GenerateByGeneric

@GenerateByGeneric
interface TestGeneric :
    JpaRepository<DictAbstractGraphNodeEntity, DictAbstractGraphNodeEntityPK>
