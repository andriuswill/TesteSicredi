package com.andriuswill.testesicredi.presentantion.ui.main

import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.presentantion.base.BaseView

interface MainView : BaseView {
    fun updateEvents(events: List<Event>)
    fun showLoader()
    fun hideLoader()
}