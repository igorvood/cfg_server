package ru.vtb.processor.intf

interface IImmutableEntity<MUTABLE> {

    fun toMutable(): MUTABLE

}