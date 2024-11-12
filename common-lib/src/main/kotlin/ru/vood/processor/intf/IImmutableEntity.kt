package ru.vood.processor.intf

interface IImmutableEntity<MUTABLE> {

    fun toMutable(): MUTABLE

    fun toUpdateble(): IUpdatebleEntity<MUTABLE>

}