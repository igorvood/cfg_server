package ru.vtb.jpaprocessor.kotlin

import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.model.abstraction.annotation
import javax.annotation.processing.ProcessingEnvironment
import javax.persistence.Column



/**
 * Custom Kotlin Class Builder which returns file content string
 * This is for learning purpose only.
 * Use KotlinPoet for production app
 * KotlinPoet can be found at https://github.com/square/kotlinpoet
 */
class KotlinImmutableDtoClassBuilder(
    className: String,
    packageName: String,
    generatedJpaRepositoryClass: GeneratedJpaRepositoryClass,
    roundEnvironment: ProcessingEnvironment
) {

    private fun String.mapKotlinType(): String{
     return   if (this=="java.lang.String") {
            "String"
        } else this

    }

    private val repositoryClassName = """${className}GeneratedRepository"""

    private val immutableClassName = """${className}Immutable"""

    private val filteredFields = generatedJpaRepositoryClass.annotatedClass.fields()
        .filter { it.element.annotation<Column>().isPresent }

    private val listFieldsConstructor = filteredFields
        .joinToString(",\n") { f -> "val " + f.name() + " : " + f.type().mapKotlinType() }

    private val listFieldsToMutableFun = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = this@toMutable.${f.name()}" }

    private val listFieldsToImmutable = filteredFields
        .joinToString(",") { f -> "this.${f.name()}" }


    private val mutableToImmutableFun = """fun ${className}.toImmutable() : $immutableClassName =  ${immutableClassName}($listFieldsToImmutable)"""
    private val immutableToMutableFun = """fun $immutableClassName.toMutable() = ${className}().apply { 
$listFieldsToMutableFun
  }"""


    private val contentTemplate = """
package $packageName.genRest

import $packageName.$className
import io.swagger.v3.oas.annotations.Operation
import ru.vtb.configuration.server.dataEntity.generated.$repositoryClassName
import $packageName.genRest.toImmutable
import org.springframework.web.bind.annotation.*


data class $immutableClassName (
$listFieldsConstructor
)
$immutableToMutableFun

$mutableToImmutableFun


"""

private val restConText=    """
@RestController
class ${className}GeneratedRestApi(
    val $repositoryClassName: $repositoryClassName
) {

    @Operation(summary = "$className findAll", tags = ["Генерированное API"])
    @GetMapping("/${className}/findAll")
    fun findAll() = $repositoryClassName.findAll().map { it.toImmutable() }

    @Operation(summary = "$className save", tags = ["Генерированное API"])
    @PutMapping("/$className/save")
    fun save(data: $immutableClassName) = $repositoryClassName.save(data.toMutable()).toImmutable()

    @Operation(summary = "$className deleteById", tags = ["Генерированное API"])
    @DeleteMapping("/$className/deleteById")
    fun deleteById(id: ${generatedJpaRepositoryClass.annotatedClass.calculateIdClass(roundEnvironment).getOrElse { "Unable to calculate primary key" }.mapKotlinType()}) = $repositoryClassName.deleteById(id)

}
"""

    fun getContent(): String =  contentTemplate+restConText

}