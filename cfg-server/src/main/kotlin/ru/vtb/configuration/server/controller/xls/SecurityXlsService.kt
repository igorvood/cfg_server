package ru.vtb.configuration.server.controller.xls

import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFSheet
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


        val sortedTopic = data.filter { it.serviceSet.isNotEmpty() }
            .sortedBy { it.topicName }
        createSheet.sheetWrite(rowNum, sortedTopic)

        val fileOutputStream = FileOutputStream("./test.xlsx")

        xssfWorkbook.write(fileOutputStream)

        xssfWorkbook.close()

    }

    private fun XSSFSheet.sheetWrite(
        rowNum: Int,
        data: Collection<TopicForReport>,
    ) {
        var rowNum1 = rowNum

        data
            .forEach { tr ->

                val endRn = topicWrite(rowNum1, tr)
                rowNum1 = endRn


            }
    }

    private fun XSSFSheet.topicWrite(
        beginRowNum: Int,
        tr: TopicForReport
    ): Int {
        var rn = beginRowNum
        val topicRow = createRow(rn)
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
                    rn += 1
                    this.createRow(rn)
                }
                srvRow.createCell(2).setCellValueDefaultStyle(srv.serviceName)
                srvRow.createCell(4).setCellValueDefaultStyle(srv.direction)
                srvRow.createCell(5).setCellValueDefaultStyle(srv.cn)
                srvRow.createCell(3).setCellValueDefaultStyle("Имя: ${srv.profileId}")
                rn += 1
                val descriptionRow = this.createRow(rn)
                descriptionRow.createCell(3).setCellValueDefaultStyle("Назначение: ${srv.reportDescription}")
                this.addMergedRegion(CellRangeAddress(rn - 1, rn, 2, 2))
                this.addMergedRegion(CellRangeAddress(rn - 1, rn, 4, 4))
                this.addMergedRegion(CellRangeAddress(rn - 1, rn, 5, 5))
            }
        this.addMergedRegion(CellRangeAddress(beginRowNum, rn, 0, 0))
        this.addMergedRegion(CellRangeAddress(beginRowNum, rn, 1, 1))
        this.addMergedRegion(CellRangeAddress(beginRowNum, rn, 6, 6))


        return rn + 1
    }
}