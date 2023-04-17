package ru.vtb.processor.wrapper

data class RestEditEntityDto<PK, DTO>(val primaryKeyWrapper: PrimaryKeyWrapper<PK>,
                                      val newData: DTO,
)
