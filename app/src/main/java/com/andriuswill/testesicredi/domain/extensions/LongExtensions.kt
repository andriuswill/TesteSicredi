package com.andriuswill.testesicredi.domain.extensions

import android.content.Context
import android.os.Build
import java.text.SimpleDateFormat
import java.util.*

fun Long.toDateText(context: Context, format: String): String {
    val date = Date(this)
    val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        context.resources.configuration.locales[0]
    } else {
        context.resources.configuration.locale
    }
    return SimpleDateFormat(format, locale).format(date)
}