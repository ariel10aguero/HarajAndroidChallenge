package com.example.harajtask

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Utils() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthAndDay(date: Int): String {
        val num = date.toLong()
        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        val dateStr = sdf.format(Date(num * 1000))

        val apiFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
        val date = LocalDate.parse(dateStr, apiFormat)

        return "${date.month}/${date.dayOfMonth}"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCompleteDate(date: Int): String {
        val num = date.toLong()
        val sdf = SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
        val dateStr = sdf.format(Date(num * 1000))
        return dateStr
    }


}


