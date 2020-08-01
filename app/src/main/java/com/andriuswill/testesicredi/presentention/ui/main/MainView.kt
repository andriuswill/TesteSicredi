package com.andriuswill.testesicredi.presentention.ui.main

import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.domain.extensions.gone
import com.andriuswill.testesicredi.domain.extensions.show
import com.andriuswill.testesicredi.presentention.ui.base.BaseView
import kotlinx.android.synthetic.main.activity_main.*

interface MainView : BaseView {
    fun updateEvents(events: List<Event>)
    fun showLoader()
    fun hideLoader()
}