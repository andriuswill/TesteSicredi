package com.andriuswill.testesicredi.presentention.ui.eventDetail

import android.content.Context
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.presentention.ui.base.BasePresenter

class EventDetailPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase
): BasePresenter<EventDetailView>() {

}