package com.andriuswill.testesicredi.domain.usecases

import android.content.Context
import com.andriuswill.testesicredi.R
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException


class RequestExceptionUseCaseImpl(
    private val context: Context
) : RequestExceptionUseCase, BaseUseCase() {

    override fun treatException(exception: Exception): String{
        try {
            return if (exception is HttpException) {
                val json = exception.response()?.errorBody()?.string()
                if (json != null) {
                    val code = JSONObject(json).getString("code").toInt()
                    val message = JSONObject(json).getString("error")
                    return message
                } else {
                    context.getString(R.string.error_default)
                }
            } else if (exception is IOException) {
                context.getString(R.string.error_internet)
            } else {
                context.getString(R.string.error_default)
            }
        } catch (e: Exception) {
            return context.getString(R.string.error_default)
        }
    }

}