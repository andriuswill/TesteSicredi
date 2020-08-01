package com.andriuswill.testesicredi.presentention.ui.main

import android.content.Context
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.presentention.ui.base.BasePresenter
import kotlinx.coroutines.launch

class MainPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase
) : BasePresenter<MainView>() {

    fun getEvents() {
        launch(coroutineContext) {
            try {
                view?.showLoader()
                val res = eventsUseCase.getEventsAsync().await()
                view?.updateEvents(res)
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