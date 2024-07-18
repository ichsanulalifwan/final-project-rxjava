package com.app.ichsanulalifwan.barani.core.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun newsDateFormatter(date: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val date = formatter.parse(date)
        val newFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault())
        return newFormat.format(date)
    }

    fun kknDateFormatter(milliseconds: Long): String {
        val date = Date(milliseconds)
        val newFormat = SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault())
        return newFormat.format(date)
    }
}