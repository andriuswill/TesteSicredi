package com.andriuswill.testesicredi.presentantion.ui.eventDetail

import android.content.Context
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.domain.usecases.RequestExceptionUseCase
import com.andriuswill.testesicredi.presentantion.base.BasePresenter
import kotlinx.coroutines.launch

class EventDetailPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase,
    private val requestExceptionUseCase: RequestExceptionUseCase
): BasePresenter<EventDetailView>() {

    fun getEvent(eventId: String) {
        launch(coroutineContext) {
            try {
                view?.showLoader()
                val event = eventsUseCase.getEventAsync(eventId).await()
                view?.showEvent(event)
            } catch (e: Exception) {
                view?.showError(
                    requestExceptionUseCase.treatException(e)
                )
            } finally {
                view?.hideLoader()
            }
        }
    }


}