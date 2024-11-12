package ru.vood.processor.wrapper

import ru.vood.processor.intf.IUpdatebleEntity

data class RestEditEntityDto<PK, DTO>(
    val primaryKeyWrapper: PrimaryKeyWrapper<PK>,
    val newData: DTO,
)


interface IRestEditEntityDto<out PK : Any, out DTO> {
    val primaryKey: PK
    val newData: IUpdatebleEntity<DTO>
}