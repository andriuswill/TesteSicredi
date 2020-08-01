package com.andriuswill.testesicredi.presentention.ui.main

import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.presentention.ui.base.BasePresenter
import kotlinx.coroutines.launch

class MainPresenter(
    private val eventsUseCase: EventsUseCase
) : BasePresenter<MainView>() {

    fun getEvents() {
        launch(coroutineContext) {
            try {
                val res = eventsUseCase.getEventsAsync().await()
                //view?.showEvents(res)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}