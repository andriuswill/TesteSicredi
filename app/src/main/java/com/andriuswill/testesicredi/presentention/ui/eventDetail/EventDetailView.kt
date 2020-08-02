package com.andriuswill.testesicredi.presentention.ui.eventDetail

import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.presentention.ui.base.BaseView

interface EventDetailView: BaseView {
    fun showLoader()
    fun hideLoader()
    fun showEvent(event: Event)
}