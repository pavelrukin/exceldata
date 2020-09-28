package com.pavelrukin.exceltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    var excelHelper: ExcelHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        excelHelper = ExcelHelper()



        btn_excel.setOnClickListener {
            val current = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                LocalDateTime.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }

            val formatter = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm")

            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val formatted = current.format(formatter)
            Log.d("TAG", "onCreate: $formatted")
            excelHelper?.writeToExcelFile("test $formatted",this)
        }
    }
}