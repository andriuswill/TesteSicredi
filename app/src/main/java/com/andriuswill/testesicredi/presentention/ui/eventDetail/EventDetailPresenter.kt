package com.andriuswill.testesicredi.presentention.ui.eventDetail

import android.content.Context
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.presentention.ui.base.BasePresenter
import kotlinx.coroutines.launch

class EventDetailPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase
): BasePresenter<EventDetailView>() {

    fun getEvent(eventId: String) {
        launch(coroutineContext) {
            try {
                view?.showLoader()
                val event = eventsUseCase.getEventAsync(eventId).await()
                view?.showEvent(event)
            } catch (e: Exception) {
                view?.showError(
                    context.resources.getString(R.string.default_error_message)
                )
            } finally {
                view?.hideLoader()
            }
        }
    }


}