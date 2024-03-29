package ru.vtb.configuration.server.controller.intf

import ru.vtb.configuration.server.controller.dto.PlaceHolder

tailrec fun extractNamesPlaceholder(
    propertyValue: String,
    inListPlace: List<String> = listOf()
): List<String> {
    val beginIndex = propertyValue.indexOf("\${")
    val endIndex = propertyValue.indexOf("}")

    return if (beginIndex != -1 && endIndex != -1 && beginIndex < endIndex) {
        val substring = propertyValue.substring(beginIndex + 2, endIndex)
        val propertyName = propertyValue.substring(endIndex + 1)
        val plus = inListPlace.plus(substring)
        extractNamesPlaceholder(propertyName, plus)
    } else inListPlace
}

tailrec fun replaceDifficultPlaceHolders(
    propertyValue: String,
    placeHolders: List<PlaceHolder>
): String {

    val extractNamesPlaceholder = extractNamesPlaceholder(propertyValue)

    return if (extractNamesPlaceholder.isEmpty())
        propertyValue
    else {
        val filter1 = placeHolders.filter { it.placeHolderName == extractNamesPlaceholder[0] }
        if (filter1.size == 1) {
            val filter = filter1.first()
            val replace = propertyValue.replace("""${"$"}{${filter.placeHolderName}}""", filter.placeHolderValue)
            if (replace == propertyValue)
                propertyValue
            else
                replaceDifficultPlaceHolders(replace, placeHolders)
        } else {
//            вдруг такого плейсхолдера не найдено. по умолчанию считается что этот плейсхолдер зарегистрирован в базе
            """${"$"}{${extractNamesPlaceholder[0]}}"""
        }


    }


}