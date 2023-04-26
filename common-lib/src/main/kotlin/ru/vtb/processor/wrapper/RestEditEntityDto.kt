package ru.vtb.processor.wrapper

import com.sun.xml.internal.ws.developer.Serialization
import ru.vtb.processor.intf.IUpdatebleEntity

@Serialization
data class RestEditEntityDto<PK, DTO>(val primaryKeyWrapper: PrimaryKeyWrapper<PK>,
                                      val newData: DTO,
)


interface IRestEditEntityDto<out PK:Any, out DTO> {
    val primaryKey: PK
    val newData: IUpdatebleEntity<DTO>
}