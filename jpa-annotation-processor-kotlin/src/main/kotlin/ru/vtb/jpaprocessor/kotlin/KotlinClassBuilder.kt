package ru.vtb.jpaprocessor.kotlin

import ru.vtb.processor.abstraction.model.GeneratedJpaRepositoryClass
import ru.vtb.processor.abstraction.model.abstraction.annotation
import javax.persistence.Column
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

/**
 * Custom Kotlin Class Builder which returns file content string
 * This is for learning purpose only.
 * Use KotlinPoet for production app
 * KotlinPoet can be found at https://github.com/square/kotlinpoet
 */
class KotlinClassBuilder(
    className: String,
    packageName:String,
    generatedJpaRepositoryClass: GeneratedJpaRepositoryClass){

val  asd=   generatedJpaRepositoryClass.annotatedClass.fields()
    .filter { it.element.annotation<Column>().isPresent }
    .map { f -> "val "+f.name()+" : "+f.type() }
    .joinToString(",\n")

    private val contentTemplate = """
package $packageName

data class $className (
$asd
)
"""

    fun getContent() : String{

        return contentTemplate

    }


}