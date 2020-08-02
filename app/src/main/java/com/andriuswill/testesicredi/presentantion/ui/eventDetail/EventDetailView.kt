package com.andriuswill.testesicredi.presentantion.ui.eventDetail

import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.presentantion.base.BaseView

interface EventDetailView: BaseView {
    fun showLoader()
    fun hideLoader()
    fun showEvent(event: Event)
}