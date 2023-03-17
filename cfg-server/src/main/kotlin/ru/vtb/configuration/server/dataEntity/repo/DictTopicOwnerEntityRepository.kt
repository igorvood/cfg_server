package ru.vtb.configuration.server.dataEntity.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity


@Repository
interface DictTopicOwnerEntityRepository: CrudRepository<DictTopicOwnerEntity, String> {

}