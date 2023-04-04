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

    private val immutableClassName = """${className}Immutable"""

    private val filteredFields = generatedJpaRepositoryClass.annotatedClass.fields()
        .filter { it.element.annotation<Column>().isPresent }

    private val listFieldsConstructor = filteredFields
        .joinToString(",\n") { f -> "val " + f.name() + " : " + mapType(f.type()) }

    private val listFieldsApply = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = this@${immutableClassName}.${f.name()}" }

    private val listFieldsToImmutable = filteredFields
        .joinToString(",") { f -> "this.${f.name()}" }



    private val contentTemplate = """
package $packageName

data class $immutableClassName (
$listFieldsConstructor
){
 val toMutable = ${className}().apply { 
  $listFieldsApply
  }
}

fun ${className}.toImmutable() : $immutableClassName =  ${immutableClassName}($listFieldsToImmutable)
"""
    fun getContent(): String =  contentTemplate

}