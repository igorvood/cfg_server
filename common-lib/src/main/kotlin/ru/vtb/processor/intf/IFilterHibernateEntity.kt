package ru.vtb.processor.intf

import java.util.regex.Pattern

interface IFilterHibernateEntity {

    fun queryString(): String

    fun params(): Map<String, Any?>

    fun isEmpty(): Boolean

    fun clean( ): String? {
        val paramNames = params().keys
        var transformedQuery = queryString()
        for (paramName in paramNames) {
            val pattern = Pattern.compile(":$paramName\\s+is\\s+null", Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(transformedQuery)
            transformedQuery = if (params()[paramName] != null) {
                matcher.replaceAll("(1!=1)")
            } else {
                matcher.replaceAll("(1=1)")
            }
        }
        return transformedQuery
    }

}