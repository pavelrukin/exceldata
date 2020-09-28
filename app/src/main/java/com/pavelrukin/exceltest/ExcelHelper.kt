package com.pavelrukin.exceltest

import android.content.Context
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream


class ExcelHelper {
    fun writeToExcelFile(documentName: String, context: Context) {
        val A1A1 = 0

        //Instantiate Excel workbook:
        val xlWb = XSSFWorkbook()
        // val xlWb = HSSFWorkbook()
        //Instantiate Excel worksheet:
        val xlWs = xlWb.createSheet()
        //Row index specifies the row in the worksheet (starting at 0):

        //Cell index specifies the column within the chosen row (starting at 0):

        //Write text value to cell located at ROW_NUMBER / COLUMN_NUMBER:
        xlWs.createRow(A1A1).createCell(A1A1).setCellValue("TEST")
        xlWs.createRow(3).createCell(2).setCellValue("row4,cell_C_")
        //Write file:
        val file: File = File(context.getExternalFilesDir(null), "$documentName.xlsx")

        val outputStream = FileOutputStream(file)
        xlWb.write(outputStream)
        xlWb.close()
    }

}