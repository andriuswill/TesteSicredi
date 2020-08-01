package com.andriuswill.testesicredi.domain.usecases

import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.data.network.AppServices
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

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

}