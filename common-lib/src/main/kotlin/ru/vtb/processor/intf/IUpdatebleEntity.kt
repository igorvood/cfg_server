package ru.vtb.processor.intf

interface IUpdatebleEntity<out MUTABLE> {

    fun toMutable(): MUTABLE

}