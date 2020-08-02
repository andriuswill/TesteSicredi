package com.andriuswill.testesicredi.presentention.ui.eventDetail.checkinDialog

import com.andriuswill.testesicredi.presentention.ui.base.BaseView

interface CheckinView : BaseView {

    fun showLoader()
    fun hideLoader()

    fun onCheckedin()
}