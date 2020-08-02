package com.andriuswill.testesicredi.presentantion.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.domain.extensions.gone
import com.andriuswill.testesicredi.domain.extensions.show
import com.andriuswill.testesicredi.domain.listener.EventClickListener
import com.andriuswill.testesicredi.presentantion.base.RootActivity
import com.andriuswill.testesicredi.presentantion.ui.eventDetail.EventDetailActivity
import com.andriuswill.testesicredi.presentantion.ui.main.adapters.EventsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.kodein.di.generic.instance

class MainActivity: RootActivity<MainView>(), MainView, EventClickListener {

    override val layoutResourceId = R.layout.activity_main

    override val presenter: MainPresenter by instance()
    private val eventsAdapter: EventsAdapter by lazy { EventsAdapter(this) }

    override fun initializeUI() {
        supportActionBar?.title = resources.getString(R.string.main_title)
        setupRecylerview()
        presenter.getEvents()
    }

    override fun initializePresenter() {
        presenter.start(this)
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun updateEvents(events: List<Event>) {
        eventsAdapter.updateEvents(events)
    }

    override fun showLoader() {
        loader.show()
    }

    override fun hideLoader() {
        loader.gone()
    }

    override fun onEventClicked(eventId: String) {
        EventDetailActivity.start(this, eventId)
    }

    private fun setupRecylerview() {
        recyclerview_events.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = eventsAdapter
            setHasFixedSize(true)
        }
    }

}