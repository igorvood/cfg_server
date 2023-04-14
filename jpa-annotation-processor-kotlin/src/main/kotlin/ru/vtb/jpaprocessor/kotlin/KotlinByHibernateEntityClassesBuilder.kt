package ru.vtb.jpaprocessor.kotlin

import ru.vtb.jpaprocessor.kotlin.builder.IKotlinContentBuilder
import ru.vtb.jpaprocessor.kotlin.builder.RepositoryTextBuilder
import ru.vtb.jpaprocessor.kotlin.builder.RestTextBuilder
import ru.vtb.processor.abstraction.AbstractGenerationProcessor
import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField
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

    private val filteredFields: List<IGeneratedField> = generatedJpaRepositoryClass.annotatedClass.fields()
        .filter { it.element.annotation<Column>().isPresent }

    private val listFieldsConstructor = filteredFields
        .joinToString(",\n") { f -> val isNullable = if (f.isNullable()) "?" else ""
            "val " + f.name() + " : " + f.type().mapKotlinType()+ isNullable
        }

    private val listFieldsToMutableFun = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = this.${f.name()}" }

    private val listFieldsToImmutable = filteredFields
        .joinToString(",") { f -> "this.${f.name()}" }

    private val mutableToImmutableFun =
        """fun ${className}.toImmutable() : $immutableClassName =  ${immutableClassName}($listFieldsToImmutable)"""
    private val immutableToMutableFun = """override fun toMutable() = ${className}().apply { 
$listFieldsToMutableFun
  }"""


    private val contentTemplate = """
package $packageName.genRest.${className.lowercase()}

import $packageName.$className
import io.swagger.v3.oas.annotations.Operation
import $packageName.genRest.${className.lowercase()}.toImmutable
import org.springframework.web.bind.annotation.*
import org.springframework.data.repository.*
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Repository
import ru.vtb.processor.intf.*
import ru.vtb.processor.annotation.GenerateByGeneric



data class $immutableClassName (
$listFieldsConstructor
):IImmutableEntity<${className}>{

$immutableToMutableFun

}

$mutableToImmutableFun


"""
    private val primaryKeyType = generatedJpaRepositoryClass.annotatedClass.calculateIdClass(roundEnvironment)
        .getOrElse { "Unable to calculate primary key" }.mapKotlinType()


    private val generatedCodeBuilders = listOf(
        RestTextBuilder(className,genRest,repositoryClassName,primaryKeyType,immutableClassName,tableComment, filteredFields),
        RepositoryTextBuilder(readOnlyEntity, className,primaryKeyType, repositoryClassName)
    )


    override fun getContent(): String = contentTemplate + generatedCodeBuilders[0].getContent()+ generatedCodeBuilders[1].getContent()

}