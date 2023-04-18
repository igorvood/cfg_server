package ru.vtb.processor.wrapper

import com.sun.xml.internal.ws.developer.Serialization

@Serialization
data class RestEditEntityDto<PK, DTO>(val primaryKeyWrapper: PrimaryKeyWrapper<PK>,
                                      val newData: DTO,
)