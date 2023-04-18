package ru.vtb.jpaprocessor.kotlin.builder

import ru.vtb.processor.abstraction.model.PrimaryKetDataTypeDto
import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField

class RestTextBuilder(
    private val className: String,
    private val genRest: Boolean,
    private val repositoryClassName: String,
    private val primaryKeyType: PrimaryKetDataTypeDto,
    private val immutableClassName: String,
    private val tableComment: String,
    private val filteredFields: List<IGeneratedField>,

    ) : IKotlinContentBuilder {

    private val listFieldsForEdit = filteredFields
        .joinToString("\n") { f -> "this@apply.${f.name()} = editData.newData.${f.name()}" }

    private fun genRestFun(): String {

        return if (genRest) {
            """
@RestController
@RequestMapping(path = arrayOf("/${className}"))
class ${className}GeneratedRestApi(
//    private val $repositoryClassName: $repositoryClassName
private val $repositoryClassName: JpaRepository<${className}, ${primaryKeyType.kotlinDataType}>,
private val orIsNullRepository: OrIsNullRepository<${className}Filter, ${className}>

): IRestHibernateEntity<$immutableClassName, ${primaryKeyType.kotlinDataType}, ${className}Filter> {

    @Operation(summary = "Найти по идентификатору.", tags = ["Генерированное API. $tableComment($className)"])
    @PutMapping("/findById", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun findById(@RequestBody id: PrimaryKeyWrapper<${primaryKeyType.kotlinDataType}>): Optional<$immutableClassName> = $repositoryClassName.findById(id.primaryKey).map{it.toImmutable()}
//    override fun findById(@RequestParam id: PrimaryKeyWrapper<${primaryKeyType.kotlinDataType}>): Optional<$immutableClassName> = $repositoryClassName.findById(id.primaryKey).map{it.toImmutable()}

    @Operation(summary = "Найти все.", tags = ["Генерированное API. $tableComment($className)"])
    @GetMapping("/findAll", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun findAll() = $repositoryClassName.findAll().map { it.toImmutable() }

    @Operation(summary = "Сохранить.", tags = ["Генерированное API. $tableComment($className)"])
    @PutMapping("/save", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun save(@RequestBody data: $immutableClassName) = $repositoryClassName.save(data.toMutable()).toImmutable()

    @Operation(summary = "Удалить по идентификатору.", tags = ["Генерированное API. $tableComment($className)"])
    @DeleteMapping("/deleteById", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun deleteById(@RequestBody id: PrimaryKeyWrapper<${primaryKeyType.kotlinDataType}>) = $repositoryClassName.deleteById(id.primaryKey)
    
    @Operation(summary = "Выбобрка с фильтром.", tags = ["Генерированное API. $tableComment($className)"])
    @PutMapping("/findByFilterOrIsNull", produces = [MediaType.APPLICATION_JSON_VALUE])
    override fun findByFilterOrIsNull(filter: ${className}Filter): List<$immutableClassName> = orIsNullRepository.findByFilterOrIsNull(filter).map { it.toImmutable() }
    
    @Operation(summary = "Редактировать значение.", tags = ["Генерированное API. $tableComment($className)"])
    @PutMapping("/editEntity", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun editEntity(
    @RequestBody editData: ${className}RestEdit
    ): $immutableClassName? { 
    val findByIdOrNull = $repositoryClassName.findByIdOrNull(editData.primaryKey)
    return findByIdOrNull?.let { oldData ->
        $repositoryClassName.save(
            oldData.apply {
                $listFieldsForEdit
            }).toImmutable()
    }
    }
    
    
    
}
""".trimMargin()
        } else ""
    }

    override fun getContent(): String = genRestFun()
}