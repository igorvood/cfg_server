package ru.vtb.processor.wrapper

import com.sun.xml.internal.ws.developer.Serialization
import ru.vtb.processor.intf.IImmutableEntity

@Serialization
data class RestEditEntityDto<PK, DTO>(val primaryKeyWrapper: PrimaryKeyWrapper<PK>,
                                      val newData: DTO,
)


interface IRestEditEntityDto<PK:Any, DTO: IImmutableEntity<*>> {
    val primaryKey: PK
    val newData: DTO
}