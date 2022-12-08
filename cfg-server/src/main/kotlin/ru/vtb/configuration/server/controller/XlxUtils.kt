package ru.vtb.configuration.server.controller

import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook

inline fun XSSFWorkbook.style(): XSSFCellStyle {
    val cellStyle: XSSFCellStyle = this.createCellStyle()

    cellStyle.borderTop = BorderStyle.MEDIUM
    cellStyle.borderBottom = BorderStyle.MEDIUM
    cellStyle.borderLeft = BorderStyle.MEDIUM
    cellStyle.borderRight = BorderStyle.MEDIUM
    return cellStyle
}

inline fun XSSFCell.setCellStyleMy(XSSFCellStyle: XSSFCellStyle): XSSFCell {
    this.cellStyle = XSSFCellStyle
    return this
}

inline fun XSSFCell.setCellValueDefaultStyle(data: String): Unit {
    val cellStyle = this.cellStyle
    cellStyle.borderTop = BorderStyle.MEDIUM
    cellStyle.borderBottom = BorderStyle.MEDIUM
    cellStyle.borderLeft = BorderStyle.MEDIUM
    cellStyle.borderRight = BorderStyle.MEDIUM

    this.setCellValue(data)

}