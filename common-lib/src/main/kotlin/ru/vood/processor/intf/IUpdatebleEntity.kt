package ru.vood.processor.intf

interface IUpdatebleEntity<out MUTABLE> {

    fun toMutable(): MUTABLE

}