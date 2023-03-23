package ru.vtb.configuration.server.dataEntity.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.vtb.configuration.server.dataEntity.DictTopicNodeEntity

@Repository
interface DictTopicNodeEntityRepository : JpaRepository<DictTopicNodeEntity, String>