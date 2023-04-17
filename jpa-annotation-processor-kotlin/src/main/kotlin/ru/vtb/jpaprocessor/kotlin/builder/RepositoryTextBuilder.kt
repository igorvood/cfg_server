package ru.vtb.jpaprocessor.kotlin.builder

import ru.vtb.processor.abstraction.model.PrimaryKetDataTypeDto

class RepositoryTextBuilder(
    private val className: String,
    private val primaryKeyType: PrimaryKetDataTypeDto,
    private val repositoryClassName: String,


    ) : IKotlinContentBuilder {

    private fun generateRepoText(): String =
        """
@Repository
@GenerateByGeneric
interface $repositoryClassName : JpaRepository<${className}, ${primaryKeyType.kotlinDataType}> {

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun <S : ${className}> save(entity: S): S

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun <S : ${className}> saveAll(entities: Iterable<S>): List<S>

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun deleteById(pk: ${primaryKeyType.kotlinDataType})

@Modifying(flushAutomatically = true)
@Transactional(propagation = Propagation.MANDATORY)
override fun deleteAllByIdInBatch(pkS: Iterable<${primaryKeyType.kotlinDataType}>)
}
""".trimIndent()

    override fun getContent(): String = generateRepoText()
}