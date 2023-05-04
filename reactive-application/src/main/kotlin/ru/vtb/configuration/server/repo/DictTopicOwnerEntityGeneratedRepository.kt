package ru.vtb.configuration.server.repo

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity

@Repository
interface DictTopicOwnerEntityGeneratedRepository : CoroutineCrudRepository<DictTopicOwnerEntity, String> {

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override suspend fun deleteAllById(ids: Iterable<String>)

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override suspend fun deleteById(id: String)

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override suspend fun <S : DictTopicOwnerEntity> save(entity: S): DictTopicOwnerEntity

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictTopicOwnerEntity> saveAll(entities: Iterable<S>): Flow<S>
}