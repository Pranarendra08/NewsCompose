package com.rendra.newscompose.util

import java.lang.Exception
import java.text.SimpleDateFormat

object DateFormatUtil {
    fun formatDate(rawDate: String): String {
        return try {
            val inputPattern = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val outPutPattern = SimpleDateFormat("dd MMM yyyy HH:mm")

            val date = inputPattern.parse(rawDate)

            outPutPattern.format(date)
        } catch (e: Exception) {
            rawDate
        }
    }
}