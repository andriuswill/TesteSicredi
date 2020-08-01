package com.andriuswill.testesicredi.domain.usecases

import com.andriuswill.testesicredi.data.models.Event
import kotlinx.coroutines.Deferred

interface EventsUseCase {
    fun getEventsAsync(): Deferred<List<Event>>
    fun getEventAsync(eventId: String): Deferred<Event>
}