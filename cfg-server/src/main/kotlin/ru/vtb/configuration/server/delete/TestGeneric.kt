package ru.vtb.configuration.server.delete

import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntity
import ru.vtb.configuration.server.dataEntity.DictAbstractGraphNodeEntityPK
import ru.vtb.processor.annotation.GenerateByGeneric
import ru.vtb.processor.annotation.MyOneGeneric
import ru.vtb.processor.annotation.MyTwoGeneric


interface Q1: MyTwoGeneric<DictAbstractGraphNodeEntity, String>

@GenerateByGeneric
interface TestGeneric :
//    MyOneGeneric<DictAbstractGraphNodeEntity>,
//    MyTwoGeneric<DictAbstractGraphNodeEntity, String>,
    Q1,
    MyTwoGeneric<DictAbstractGraphNodeEntity, String>
