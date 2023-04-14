package ru.vtb.configuration.server.delete

import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.processor.annotation.GenerateByGeneric


interface MyTwoGeneric<IN, OUT>

@GenerateByGeneric
interface TestGeneric :
    MyTwoGeneric<DictAbstractGraphNodeEntity, DictAbstractGraphNodeEntityPK>
