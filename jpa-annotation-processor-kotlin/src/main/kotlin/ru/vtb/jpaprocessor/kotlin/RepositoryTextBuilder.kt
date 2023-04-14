package ru.vtb.jpaprocessor.kotlin

class RepositoryTextBuilder(val readOnlyEntity: Boolean

):IKotlinContentBuilder {

    val asads = """



@Repository
interface DictTopicOwnerEntityGeneratedRepository : JpaRepository<DictTopicOwnerEntity, String> {
    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictTopicOwnerEntity> save(entity: S): S
    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun <S : DictTopicOwnerEntity> saveAll(entities: Iterable<S>): List<S>
    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteById(pk: String)
    @Modifying(flushAutomatically = true)
    @Transactional(propagation = Propagation.MANDATORY)
    override fun deleteAllByIdInBatch(pkS: Iterable<String>)
}"""

    override fun getContent(): String = asads
}