package ru.vtb.processor.wrapper

import ru.vtb.processor.intf.IUpdatebleEntity

data class RestEditEntityDto<PK, DTO>(val primaryKeyWrapper: PrimaryKeyWrapper<PK>,
                                      val newData: DTO,
)


interface IRestEditEntityDto<out PK:Any, out DTO> {
    val primaryKey: PK
    val newData: IUpdatebleEntity<DTO>
}