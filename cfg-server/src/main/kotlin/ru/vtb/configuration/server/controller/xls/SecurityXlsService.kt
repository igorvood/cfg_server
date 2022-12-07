package ru.vtb.configuration.server.controller.xls

import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import ru.vtb.configuration.server.controller.setCellValueDefaultStyle
import ru.vtb.configuration.server.controller.style
import ru.vtb.configuration.server.repo.dto.TopicForReport
import java.io.FileOutputStream

@Service
class SecurityXlsService : XlsService<TopicForReport> {

    override fun repTopics(data: Collection<TopicForReport>) {
        val xssfWorkbook = XSSFWorkbook()
        var rowNum = 0
        var colNum = 0
        val cellStyle: XSSFCellStyle = xssfWorkbook.style()
        val createSheet = xssfWorkbook.createSheet()

        createSheet.defaultColumnWidth = 40

        val createRowHead = createSheet.createRow(rowNum++)
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("Топик")
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("Владелец")
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("Сервис")
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("Профиль")
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("READ/WRITE")
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("CN")
        createRowHead.createCell(colNum++).setCellValueDefaultStyle("Параметры")


        data
            .filter { it.serviceSet.isNotEmpty() }
            //            .filter { it.topicName in listOf("p0__dko_uasp__card_agreement_converted", "p0__dko_uasp__pension_converted") }
            .sortedBy { it.topicName }

            .forEach { tr ->

                val beginRowNum = rowNum
                var topicRow = createSheet.createRow(rowNum)
                topicRow.createCell(0).setCellValueDefaultStyle(tr.topicName)
                topicRow.createCell(1).setCellValueDefaultStyle("Добавить владельца")
                topicRow.createCell(6)
                    .setCellValueDefaultStyle("retention: " + tr.retention + "\ncleanup policy: " + tr.cleanupPolicy + "\npartition: " + tr.cntPartition)

                tr.serviceSet
                    .sortedBy { s -> s.serviceName }
                    .withIndex()
                    .forEach { srvInd ->
                        val index = srvInd.index
                        val srv = srvInd.value
                        val srvRow = if (index == 0) topicRow else {
                            rowNum += 1
                            createSheet.createRow(rowNum)
                        }
                        srvRow.createCell(2).setCellValueDefaultStyle(srv.serviceName)
                        srvRow.createCell(4).setCellValueDefaultStyle(srv.direction)
                        srvRow.createCell(5).setCellValueDefaultStyle(srv.cn)
                        srvRow.createCell(3).setCellValueDefaultStyle("Имя: ${srv.profileId}")
                        rowNum += 1
                        val descriptionRow = createSheet.createRow(rowNum)
                        descriptionRow.createCell(3).setCellValueDefaultStyle("Назначение: ${srv.reportDescription}")
                        createSheet.addMergedRegion(CellRangeAddress(rowNum - 1, rowNum, 2, 2))
                        createSheet.addMergedRegion(CellRangeAddress(rowNum - 1, rowNum, 4, 4))
                        createSheet.addMergedRegion(CellRangeAddress(rowNum - 1, rowNum, 5, 5))
                    }
                createSheet.addMergedRegion(CellRangeAddress(beginRowNum, rowNum, 0, 0))
                createSheet.addMergedRegion(CellRangeAddress(beginRowNum, rowNum, 1, 1))
                createSheet.addMergedRegion(CellRangeAddress(beginRowNum, rowNum, 6, 6))

                rowNum += 1

            }

        val fileOutputStream = FileOutputStream("./test.xlsx")

        xssfWorkbook.write(fileOutputStream)

        xssfWorkbook.close()

    }
}