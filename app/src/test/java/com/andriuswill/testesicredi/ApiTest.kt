package com.andriuswill.testesicredi

import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.data.network.ApiBuilder
import com.andriuswill.testesicredi.data.network.AppServices
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ApiTest {

    private val builder = ApiBuilder()
    private val service = AppServices.instance(builder)

    @Test
    fun testGetEvents() {
        val events = runBlocking{ getEvents()}
        assertEquals(events.isNotEmpty(), true)
    }


    @Test
    fun testGetEvent() {
        val event = runBlocking{ getEvent("1")}
        assertEquals(event is Event, true)
    }

    private suspend fun getEvents() = service.getEventsAsync().await()

    private suspend fun getEvent(eventId: String) = service.getEventAsync(eventId).await()

}