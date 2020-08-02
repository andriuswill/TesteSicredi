package com.andriuswill.testesicredi.presentantion.ui.main

import android.content.Context
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.domain.usecases.RequestExceptionUseCase
import com.andriuswill.testesicredi.presentantion.base.BasePresenter
import kotlinx.coroutines.launch

class MainPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase,
    private val requestExceptionUseCase: RequestExceptionUseCase
) : BasePresenter<MainView>() {

    fun getEvents() {
        launch(coroutineContext) {
            try {
                view?.showLoader()
                val res = eventsUseCase.getEventsAsync().await()
                view?.updateEvents(res)
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