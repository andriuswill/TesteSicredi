package com.andriuswill.testesicredi.presentantion.ui.eventDetail.checkinDialog

import com.andriuswill.testesicredi.presentantion.base.BaseView

interface CheckinView : BaseView {

    fun showLoader()
    fun hideLoader()

    fun onCheckedin()
}