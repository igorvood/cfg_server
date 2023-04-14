package ru.vtb.jpaprocessor.kotlin

import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.model.abstraction.annotation
import ru.vtb.processor.annotation.GenerateJpa
import javax.annotation.processing.ProcessingEnvironment
import javax.persistence.Column


/**
 * Custom Kotlin Class Builder which returns file content string
 * This is for learning purpose only.
 * Use KotlinPoet for production app
 * KotlinPoet can be found at https://github.com/square/kotlinpoet
 */
class KotlinByHibernateEntityClassesBuilder(
    className: String,
    packageName: String,
    generatedJpaRepositoryClass: GeneratedJpaRepositoryClass,
    roundEnvironment: ProcessingEnvironment
) : IKotlinContentBuilder {

    private fun String.mapKotlinType(): String = if (this == "java.lang.String") {
        "String"
    } else this

    private val generateJpaValue = generatedJpaRepositoryClass.annotatedClass.element.annotation<GenerateJpa>().get()

    private val tableComment = generateJpaValue.tableComment

    private val genRest = generateJpaValue.genRest

    private val readOnlyEntity = generateJpaValue.readOnly


    private val repositoryClassName = """${className}GeneratedRepository"""

    private val immutableClassName = """${className}Immutable"""

    private val filteredFields = generatedJpaRepositoryClass.annotatedClass.fields()
        .filter { it.element.annotation<Column>().isPresent }

    private val listFieldsConstructor = filteredFields
        .joinToString(",\n") { f -> val isNullable = if (f.isNullable()) "?" else ""
            "val " + f.name() + " : " + f.type().mapKotlinType()+ isNullable
        }

    private val listFieldsToMutableFun = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = this@toMutable.${f.name()}" }

    private val listFieldsToImmutable = filteredFields
        .joinToString(",") { f -> "this.${f.name()}" }
    private val listFieldsForEdit = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = newData.${f.name()}" }

    private val mutableToImmutableFun =
        """fun ${className}.toImmutable() : $immutableClassName =  ${immutableClassName}($listFieldsToImmutable)"""
    private val immutableToMutableFun = """fun $immutableClassName.toMutable() = ${className}().apply { 
$listFieldsToMutableFun
  }"""


    private val contentTemplate = """
package $packageName.genRest

import $packageName.$className
import io.swagger.v3.oas.annotations.Operation
import $packageName.genRest.toImmutable
import org.springframework.web.bind.annotation.*
import org.springframework.data.repository.*
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Repository




data class $immutableClassName (
$listFieldsConstructor
)
$immutableToMutableFun

$mutableToImmutableFun


"""
    private val primaryKeyType = generatedJpaRepositoryClass.annotatedClass.calculateIdClass(roundEnvironment)
        .getOrElse { "Unable to calculate primary key" }.mapKotlinType()



    private val repoText = generateRepoText(className, primaryKeyType)

    private fun generateRepoText(className: String,
                                 primaryKeyType: String): String =
"""
@Repository
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


private val restConText = if (genRest) {
        """
    @RestController
    class ${className}GeneratedRestApi(
        val $repositoryClassName: $repositoryClassName
    ) {
    
        @Operation(summary = "Найти все.", tags = ["Генерированное API. $tableComment($className)"])
        @GetMapping("/${className}/findAll")
        fun findAll() = $repositoryClassName.findAll().map { it.toImmutable() }
    
        @Operation(summary = "Сохранить.", tags = ["Генерированное API. $tableComment($className)"])
        @PutMapping("/$className/save")
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        fun save(@RequestBody data: $immutableClassName) = $repositoryClassName.save(data.toMutable()).toImmutable()
    
        @Operation(summary = "Удалить по идентификатору.", tags = ["Генерированное API. $tableComment($className)"])
        @DeleteMapping("/$className/deleteById")
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        fun deleteById(@RequestBody id: $primaryKeyType) = $repositoryClassName.deleteById(id)
        
        @Operation(summary = "Редактировать значение.", tags = ["Генерированное API. $tableComment($className)"])
        @PostMapping("/$className/editEntity")
        @Transactional(propagation = Propagation.REQUIRES_NEW)
        fun editEntity(
            @RequestBody primaryKey: $primaryKeyType,
            @RequestBody newData: $immutableClassName
        ) = $repositoryClassName.findByIdOrNull(primaryKey)?.let { oldData ->
            $repositoryClassName.save(
                oldData.apply {
                    $listFieldsForEdit
                }).toImmutable()
        }
    }
"""
    } else ""

    override fun getContent(): String = contentTemplate + restConText+repoText

}