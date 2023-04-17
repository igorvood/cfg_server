package ru.vtb.jpaprocessor.kotlin.builder

import ru.vtb.processor.abstraction.model.abstraction.IGeneratedField

class RestTextBuilder(
    private val className: String,
    private val genRest: Boolean,
    private val repositoryClassName: String,
    private val primaryKeyType: String,
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
        class ${className}GeneratedRestApi(
        //    private val $repositoryClassName: $repositoryClassName
        private val $repositoryClassName: JpaRepository<${className}, $primaryKeyType>
        
        ): IRestHibernateEntity<$immutableClassName, $primaryKeyType> {

            @Operation(summary = "Найти по идентификатору.", tags = ["Генерированное API. $tableComment($className)"])
            @GetMapping("/${className}/findById")
            override fun findById(@RequestParam id: $primaryKeyType): Optional<$immutableClassName> = $repositoryClassName.findById(id).map{it.toImmutable()}  
        
            @Operation(summary = "Найти все.", tags = ["Генерированное API. $tableComment($className)"])
            @GetMapping("/${className}/findAll")
            override fun findAll() = $repositoryClassName.findAll().map { it.toImmutable() }
        
            @Operation(summary = "Сохранить.", tags = ["Генерированное API. $tableComment($className)"])
            @PutMapping("/$className/save")
            @Transactional(propagation = Propagation.REQUIRES_NEW)
            override fun save(@RequestBody data: $immutableClassName) = $repositoryClassName.save(data.toMutable()).toImmutable()
        
            @Operation(summary = "Удалить по идентификатору.", tags = ["Генерированное API. $tableComment($className)"])
            @DeleteMapping("/$className/deleteById")
            @Transactional(propagation = Propagation.REQUIRES_NEW)
            override fun deleteById(@RequestBody id: $primaryKeyType) = $repositoryClassName.deleteById(id)
            
            @Operation(summary = "Редактировать значение.", tags = ["Генерированное API. $tableComment($className)"])
            @PostMapping("/$className/editEntity")
            @Transactional(propagation = Propagation.REQUIRES_NEW)
            override fun editEntity(
                @RequestBody primaryKey: $primaryKeyType,
                @RequestBody newData: $immutableClassName
            ) = $repositoryClassName.findByIdOrNull(primaryKey)?.let { oldData ->
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