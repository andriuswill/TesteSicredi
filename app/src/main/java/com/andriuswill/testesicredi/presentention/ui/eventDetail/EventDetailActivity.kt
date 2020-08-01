package com.andriuswill.testesicredi.presentention.ui.eventDetail

import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.presentention.ui.base.RootActivity
import org.jetbrains.anko.toast
import org.kodein.di.generic.instance

class EventDetailActivity : RootActivity<EventDetailView>(), EventDetailView {

    override val layoutResourceId = R.layout.activity_event_detail

    override val presenter: EventDetailPresenter by instance()

    override fun initializeUI() {

    }

    override fun initializePresenter() {
        presenter.start(this)
    }

    override fun showError(message: String) {
        toast(message)
    }

}