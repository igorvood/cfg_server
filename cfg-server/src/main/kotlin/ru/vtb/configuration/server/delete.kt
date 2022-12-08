package ru.vtb.configuration.server

import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ru.vtb.configuration.server.controller.setCellStyleMy
import java.io.FileOutputStream


fun main1(ar: Array<String>) {
    val xssfWorkbook = XSSFWorkbook()

    val cellStyle: XSSFCellStyle = xssfWorkbook.createCellStyle();

    cellStyle.setBorderTop(BorderStyle.MEDIUM);
    cellStyle.setBorderBottom(BorderStyle.MEDIUM);
    cellStyle.setBorderLeft(BorderStyle.MEDIUM);
    cellStyle.setBorderRight(BorderStyle.MEDIUM);


    val createSheet = xssfWorkbook.createSheet()

    val createRow1 = createSheet.createRow(0)
    val createRow2 = createSheet.createRow(1)



    createRow1.createCell(0).setCellStyleMy(cellStyle).setCellValue("asdasdasddasddddd ddddddd dddd ddd")
    createRow2.createCell(0).setCellStyleMy(cellStyle)
        .setCellValue("klhglkjmglk asdjh khkj hasjkdh asjkdh jkash djkas hdjkas hdjkhask")

    createRow1.createCell(1).setCellStyleMy(cellStyle).setCellValue("owner")

    createRow1.createCell(2).setCellStyleMy(cellStyle).setCellValue("789")
    createRow2.createCell(2).setCellStyleMy(cellStyle).setCellValue("2342")

    val addMergedRegion = createSheet.addMergedRegion(CellRangeAddress(0, 1, 1, 1))


    val fileOutputStream = FileOutputStream("./test.xlsx")

    xssfWorkbook.write(fileOutputStream)

    xssfWorkbook.close()

}

