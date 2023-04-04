package ru.vtb.jpaprocessor.kotlin

import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.model.abstraction.annotation
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
    generatedJpaRepositoryClass: GeneratedJpaRepositoryClass
) {

    private fun mapType(type: String): String{
     return   if (type=="java.lang.String") {
            "String"
        } else type

    }

    private val repositoryClassName = """${className}GeneratedRepository"""

    private val immutableClassName = """${className}Immutable"""

    private val filteredFields = generatedJpaRepositoryClass.annotatedClass.fields()
        .filter { it.element.annotation<Column>().isPresent }

    private val listFieldsConstructor = filteredFields
        .joinToString(",\n") { f -> "val " + f.name() + " : " + mapType(f.type()) }

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
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.vtb.configuration.server.dataEntity.generated.$repositoryClassName
import $packageName.genRest.toImmutable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping


data class $immutableClassName (
$listFieldsConstructor
)
$immutableToMutableFun

$mutableToImmutableFun


"""

private val restConText=    """
@RestController
class ${className}GeneratedRestApi(
    val $repositoryClassName: ${className}GeneratedRepository
) {

    @Operation(summary = "$className findAll", tags = ["Генерированное API"])
    @GetMapping("/${className}/findAll")
    fun findAll() = ${className}GeneratedRepository.findAll().map { it.toImmutable() }

    @Operation(summary = "$className save", tags = ["Генерированное API"])
    @PutMapping("/$className/save")
    fun save(data: $immutableClassName) = ${className}GeneratedRepository.save(data.toMutable()).toImmutable()


}
"""
    fun getContent(): String =  contentTemplate+restConText

}