package com.andriuswill.testesicredi.data.network

import com.andriuswill.testesicredi.data.models.Event
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path


interface AppServices {

    @GET("events/")
    fun getEventsAsync(): Deferred<List<Event>>

    @GET("events/{eventId}")
    fun getEventAsync(
        @Path("eventId") eventId: String
    ): Deferred<Event>

    companion object {
        fun instance(builder: ApiBuilder): AppServices =
            builder.retrofit().create(AppServices::class.java)

    }
}