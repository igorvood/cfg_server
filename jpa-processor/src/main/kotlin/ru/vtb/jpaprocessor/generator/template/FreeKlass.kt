package ru.vtb.jpaprocessor.generator.template

import ru.vtb.jpaprocessor.generator.model.IAnnotatedClass
import ru.vtb.jpaprocessor.generator.model.OrIsNullField
import java.util.stream.Collectors

class FreeKlass(private val orIsNullSearchInterface: IAnnotatedClass?) {
    val packageName: String
        get() = orIsNullSearchInterface!!.packageName()
    val fullname: String
        get() = orIsNullSearchInterface!!.name()
    val shortname: String
        get() = orIsNullSearchInterface!!.shortName()
    val fields: List<FreeField>
        get() = orIsNullSearchInterface!!.fields().stream()
                .map { f: OrIsNullField -> FreeField(f) }
                .collect(Collectors.toList())
}