package ru.vtb.jpaprocessor.kotlin

import ru.vtb.jpaprocessor.kotlin.builder.*
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

    private val generateJpaValue = generatedJpaRepositoryClass.annotatedClass.element.annotation<GenerateJpa>().get()

    private val tableComment = generateJpaValue.tableComment

    private val genRest = generateJpaValue.genRest

    private val readOnlyEntity = generateJpaValue.readOnly


    private val repositoryClassName = """${className}GeneratedRepository"""

    private val immutableClassName = """${className}Immutable"""

    private val filteredFields: List<IGeneratedField> = generatedJpaRepositoryClass.annotatedClass.fields()
        .filter { it.element.annotation<Column>().isPresent }

    private val importText = """
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
import java.util.*
import ru.vtb.processor.wrapper.*
import org.springframework.http.MediaType

"""


    private val primaryKeyType = generatedJpaRepositoryClass.annotatedClass.calculateIdClass(roundEnvironment)
        .getOrElse { throw java.lang.IllegalStateException("Unable to calculate primary key ") }


    private val generatedCodeBuilders = listOf(
        DTOsTextBuilder(className, immutableClassName, filteredFields),
        RepositoryTextBuilder(className, primaryKeyType, repositoryClassName),
        RestTextBuilder(
            className,
            genRest,
            repositoryClassName,
            primaryKeyType,
            immutableClassName,
            tableComment,
            filteredFields
        ),

        )


    override fun getContent(): String = importText +
            generatedCodeBuilders.joinToString("\n\n") { it.getContent() }


}