package ru.vtb.configuration.server.dataEntity.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK

@EnableJpaRepositories
interface DictAbstractGraphNodeRepository: JpaRepository<DictAbstractGraphNodeEntity, DictAbstractGraphNodeEntityPK> {
}