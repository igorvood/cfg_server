package ru.vtb.processor.wrapper

import com.sun.xml.internal.ws.developer.Serialization


@Serialization
data class PrimaryKeyWrapper<T>(val primaryKey: T)
