package com.andriuswill.testesicredi.presentantion.ui.eventDetail.checkinDialog

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.data.models.People
import com.andriuswill.testesicredi.domain.extensions.hide
import com.andriuswill.testesicredi.domain.extensions.show
import com.andriuswill.testesicredi.domain.listener.EventCheckinListener
import com.andriuswill.testesicredi.presentantion.base.RootDialogFragment
import kotlinx.android.synthetic.main.dialog_fragment_checkin.*
import org.jetbrains.anko.toast
import org.kodein.di.generic.instance

class CheckinDialogFragment : RootDialogFragment<CheckinView>(), CheckinView {

    override val layoutResourceId = R.layout.dialog_fragment_checkin
    override val presenter: CheckinPresenter by instance()

    private val eventId: String? by lazy { arguments?.getString(EXTRA_EVENT_ID) }

    override fun initializeUI() {
        btn_checkin.setOnClickListener {
            presenter.checkin(
                eventId,
                edit_name.text.toString(),
                edit_email.text.toString()
            )
        }
        btn_cancel.setOnClickListener {
            dismiss()
        }
    }

    override fun showLoader(){
        layout_form?.hide()
        loader?.show()
    }

    override fun hideLoader(){
        layout_form?.show()
        loader?.hide()
    }

    override fun onCheckedin(people: People){
        activity?.let {
            (it as EventCheckinListener).onCheckin(people)
        }
        context?.let {
            it.toast(it.getString(R.string.checkin_ok))
        }
        dismiss()
    }

    override fun initializePresenter() {
        presenter.start(this)
    }

    override fun showError(message: String) {
        context?.toast(message)
    }

    companion object {
        private const val EXTRA_EVENT_ID = "EXTRA_EVENT_ID"
        private const val TAG = "TAG+CHECKIN_DIALOG_FRAGMENT"


        fun show(eventId: String, fragmentManager: FragmentManager) {
            val args = Bundle()
            args.putString(EXTRA_EVENT_ID, eventId)
            val fragment = CheckinDialogFragment()
            fragment.arguments = args
            fragment.isCancelable = false
            fragment.show(fragmentManager, TAG)
        }
    }

}