package ru.vtb.configuration.server.dataEntity.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity

@Repository
interface DictTopicOwnerEntityRepository : JpaRepository<DictTopicOwnerEntity, String> {
    @Modifying(flushAutomatically = true)
    @Query("update DictTopicOwnerEntity u set u.id = :newId where u.id = :id")
    @Transactional(propagation = Propagation.MANDATORY)
    fun update(
        @Param("id") id: String,
        @Param("newId") newId: String //                @Param("newVals") DictTopicOwnerEntity dictTopicOwnerEntity
    ): Int
}