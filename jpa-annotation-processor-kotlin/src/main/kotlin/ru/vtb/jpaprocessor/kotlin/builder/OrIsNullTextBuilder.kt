package ru.vtb.jpaprocessor.kotlin.builder

class OrIsNullTextBuilder(
    private val className: String,

    ) : IKotlinContentBuilder {

    private fun genOrIsNullRepository(): String {

        return """
@Service
class ${className}OrIsNullRepository(
    emf: EntityManagerFactory
) : OrIsNullRepository<${className}Filter, ${className}>(emf, ${className}::class.java)
""".trimMargin()

    }

    override fun getContent(): String = genOrIsNullRepository()
}