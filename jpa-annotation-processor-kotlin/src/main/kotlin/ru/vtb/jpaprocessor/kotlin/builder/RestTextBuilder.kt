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
        .joinToString("\n") { f -> "this@apply.${f.name()} = newData.${f.name()}" }

    private fun genRestFun(): String {

        return if (genRest) {
            """
@RestController
@RequestMapping(path = arrayOf("/${className}"))
class ${className}GeneratedRestApi(
//    private val $repositoryClassName: $repositoryClassName
private val $repositoryClassName: JpaRepository<${className}, ${primaryKeyType.kotlinDataType}>

): IRestHibernateEntity<$immutableClassName, ${primaryKeyType.kotlinDataType}> {

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
    
    @Operation(summary = "Редактировать значение.", tags = ["Генерированное API. $tableComment($className)"])
    @PostMapping("/editEntity", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    override fun editEntity(
//        @RequestBody editData: RestEditEntityDto<${primaryKeyType.kotlinDataType}, $immutableClassName>,
@RequestBody primaryKeyWrapper: PrimaryKeyWrapper<${primaryKeyType.kotlinDataType}>, 
@RequestBody newData: $immutableClassName,
    ) = $repositoryClassName.findByIdOrNull(primaryKeyWrapper.primaryKey)?.let { oldData ->
        $repositoryClassName.save(
            oldData.apply {
                $listFieldsForEdit
            }).toImmutable()
    }
}
""".trimMargin()
        } else ""
    }

    override fun getContent(): String = genRestFun()
}