package com.andriuswill.testesicredi.presentantion.ui.eventDetail

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.data.models.Event
import com.andriuswill.testesicredi.domain.extensions.gone
import com.andriuswill.testesicredi.domain.extensions.show
import com.andriuswill.testesicredi.domain.extensions.toDateText
import com.andriuswill.testesicredi.presentantion.base.RootActivity
import com.andriuswill.testesicredi.presentantion.ui.eventDetail.checkinDialog.CheckinDialogFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_event_detail.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.kodein.di.generic.instance

class EventDetailActivity : RootActivity<EventDetailView>(), EventDetailView, OnMapReadyCallback {


    override val layoutResourceId = R.layout.activity_event_detail

    override val presenter: EventDetailPresenter by instance()

    private val eventId: String by lazy { intent.getStringExtra(EXTRA_EVENT_ID) }
    private val mapFragment by lazy {
        supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
    }
    private var mMap: GoogleMap? = null


    override fun initializeUI() {
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mapFragment.view?.gone()
        mapFragment.getMapAsync(this)
        presenter.getEvent(eventId)
    }

    override fun initializePresenter() {
        presenter.start(this)
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun showLoader() {
        loader.show()
    }

    override fun hideLoader() {
        loader.gone()
    }

    override fun showEvent(event: Event) {
        supportActionBar?.title = event.title
        text_description.text = event.description
        text_date.text = event.date.toDateText(this, DATE_FORMAT)
        layout_event_info.show()

        btn_share.setOnClickListener {
            shareEvent(event.description)
        }

        btn_checkin.setOnClickListener {
            CheckinDialogFragment.show(event.id, supportFragmentManager)

        }

        val place = LatLng(event.latitude, event.longitude)
        mMap?.addMarker(MarkerOptions().position(place).title(event.title))
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 16f))
        mapFragment.view?.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return false
    }

    private fun shareEvent(text: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "it.description")
        startActivity(Intent.createChooser(intent, "Compartilhar"))
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    companion object {
        private const val EXTRA_EVENT_ID = "EXTRA_EVENT_ID"
        private const val DATE_FORMAT = "dd/MM/yyyy"

        fun start(context: Context, eventId: String) {
            context.startActivity<EventDetailActivity>(
                EXTRA_EVENT_ID to eventId
            )
        }
    }

}