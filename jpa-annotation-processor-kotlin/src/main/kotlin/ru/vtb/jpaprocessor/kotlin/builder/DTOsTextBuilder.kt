package ru.vtb.jpaprocessor.kotlin.builder

import ru.vtb.processor.abstraction.model.PrimaryKetDataTypeDto
import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField
import ru.vtb.processor.abstraction.model.abstraction.mapKotlinType

class DTOsTextBuilder(
    private val className: String,
    private val immutableClassName: String,
    private val filteredFields: List<IGeneratedField>,
    private val primaryKeyType: PrimaryKetDataTypeDto,

    ) : IKotlinContentBuilder {

    private val listFieldsToImmutable = filteredFields
        .joinToString(",") { f -> "this.${f.name()}" }


    private val listFieldsForEdit = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = newData.${f.name()}" }


    private val listFieldsToMutableFun = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = this@$immutableClassName.${f.name()}" }


    private val immutableToMutableFun = """override fun toMutable() = ${className}().apply { 
$listFieldsToMutableFun
  }"""

    private val mutableToImmutableFun =
        """fun ${className}.toImmutable() : $immutableClassName =  ${immutableClassName}($listFieldsToImmutable)"""


    private val listFieldsConstructor = filteredFields
        .joinToString(",\n") { f ->
            val isNullable = if (f.isNullable()) "?" else ""
            "val " + f.name() + " : " + f.type().mapKotlinType() + isNullable
        }

    private fun getDtos(): String {
        return """
@kotlinx.serialization.Serializable
data class $immutableClassName (
$listFieldsConstructor
):IImmutableEntity<${className}>{

$immutableToMutableFun

}

data class ${className}RestEdit(
    override val primaryKey: ${primaryKeyType.kotlinDataType},
    override val newData: $immutableClassName
): IRestEditEntityDto<${primaryKeyType.kotlinDataType}, $immutableClassName> 

$mutableToImmutableFun"""
    }

    override fun getContent(): String = getDtos()
}