package com.andriuswill.testesicredi.data.network

import com.andriuswill.testesicredi.data.models.CheckinRequest
import com.andriuswill.testesicredi.data.models.Event
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface AppServices {

    @GET("events/")
    fun getEventsAsync(): Deferred<List<Event>>

    @GET("events/{eventId}")
    fun getEventAsync(
        @Path("eventId") eventId: String
    ): Deferred<Event>

    @POST("checkin")
    fun checkinAsync(
        @Body body: CheckinRequest
    ): Deferred<ResponseBody>

    companion object {
        fun instance(builder: ApiBuilder): AppServices =
            builder.retrofit().create(AppServices::class.java)

    }
}