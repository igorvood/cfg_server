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

    private val listFieldsConstructorNullable = filteredFields
        .joinToString(",\n") { f ->
            "val ${f.name()} : ${f.type().mapKotlinType()}?"
        }

    private val listFilterIsEmpty = filteredFields
        .joinToString("&&\n") { f ->
            "${f.name()} == null "
        }

    private val listSqlFilterIsEmpty = filteredFields
        .joinToString(" and ") { f ->
            "(d.${f.name()} = :${f.name()} or :${f.name()} is null)"
        }

    private val listSqlFilterNull = filteredFields
        .joinToString(", ") { f ->
            "null"
        }

    private val listSqlFilterMapParams = filteredFields
        .joinToString(",\n") { f ->
            """ "${f.name()}" to ${f.name()} """
        }


//    "graphId" to this.graphId
//    (b.author = :author   or :author is null)

    private fun getDtos(): String {
        return """
@kotlinx.serialization.Serializable
data class $immutableClassName (
$listFieldsConstructor
):IImmutableEntity<${className}>{

$immutableToMutableFun

}

@kotlinx.serialization.Serializable
data class ${className}Filter (
$listFieldsConstructorNullable
): IFilterHibernateEntity{
  
  override fun params(): Map<String, Any?> = mapOf(
$listSqlFilterMapParams
        )
  
  override fun queryString(): String = queryStringConst

  override fun isEmpty(): Boolean {
        return $listFilterIsEmpty
    }
    
    companion object{
        private val queryStringConst: String = "select d from ${className} d where 1=1 and ${listSqlFilterIsEmpty}"
        
        val nullConst = ${className}Filter($listSqlFilterNull)
              
    }
    
}


//@kotlinx.serialization.Serializable
data class ${className}RestEdit(
    override val primaryKey: ${primaryKeyType.kotlinDataType},
    override val newData: $immutableClassName
): IRestEditEntityDto<${primaryKeyType.kotlinDataType}, $immutableClassName> 

$mutableToImmutableFun"""
    }

    override fun getContent(): String = getDtos()
}