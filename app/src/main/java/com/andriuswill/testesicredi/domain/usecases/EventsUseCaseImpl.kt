package com.andriuswill.testesicredi.domain.usecases

import com.andriuswill.testesicredi.data.models.CheckinRequest
import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.data.network.AppServices
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import okhttp3.ResponseBody

class EventsUseCaseImpl(
    private val appServices: AppServices
) : EventsUseCase, BaseUseCase() {

    override fun getEventsAsync(): Deferred<List<Event>> =
        async(coroutineContext) {
            return@async appServices.getEventsAsync().await()
        }

    override fun getEventAsync(eventId: String): Deferred<Event> =
        async(coroutineContext) {
            return@async appServices.getEventAsync(eventId).await()
        }

    override fun checkinAsync(
        eventId: String,
        name: String,
        email: String
    ): Deferred<ResponseBody> =
        async(coroutineContext) {
            val body = CheckinRequest(
                eventId = eventId,
                name = name,
                email = email
            )
            return@async appServices.checkinAsync(body).await()
        }
}