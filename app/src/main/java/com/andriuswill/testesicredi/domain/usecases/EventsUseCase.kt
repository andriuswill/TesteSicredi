package com.andriuswill.testesicredi.domain.usecases

import com.andriuswill.testesicredi.data.models.Event
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody

interface EventsUseCase {
    fun getEventsAsync(): Deferred<List<Event>>
    fun getEventAsync(eventId: String): Deferred<Event>
    fun checkinAsync(eventId: String, name: String, email: String): Deferred<ResponseBody>
}