package ru.vtb.jpaprocessor.kotlin.builder

class RepositoryTextBuilder(private val readOnlyEntity: Boolean,
                            private val className: String,
                            private val primaryKeyType: String,
                            private val repositoryClassName: String,


): IKotlinContentBuilder {

    private fun generateRepoText(): String =
        """
@Repository
@GenerateByGeneric
interface $repositoryClassName : JpaRepository<${className}, $primaryKeyType> {

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun <S : ${className}> save(entity: S): S

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun <S : ${className}> saveAll(entities: Iterable<S>): List<S>

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun deleteById(pk: $primaryKeyType)

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun deleteAllByIdInBatch(pkS: Iterable<$primaryKeyType>)
}
""".trimIndent()

    override fun getContent(): String = generateRepoText()
}