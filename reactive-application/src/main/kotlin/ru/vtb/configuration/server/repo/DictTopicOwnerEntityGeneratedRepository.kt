package ru.vtb.configuration.server.repo

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.vtb.configuration.server.dataEntity.DictTopicOwnerEntity

@Repository
interface DictTopicOwnerEntityGeneratedRepository : R2dbcRepository<DictTopicOwnerEntity, String> {
    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictTopicOwnerEntity> save(entity: S): Mono<S>

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictTopicOwnerEntity> saveAll(entities: MutableIterable<S>): Flux<S>

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteById(id: String): Mono<Void>

    @Modifying
    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteAllById(ids: MutableIterable<String>): Mono<Void>

}