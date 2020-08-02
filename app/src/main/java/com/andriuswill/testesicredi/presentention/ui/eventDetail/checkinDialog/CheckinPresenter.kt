package com.andriuswill.testesicredi.presentention.ui.eventDetail.checkinDialog

import android.content.Context
import android.util.Patterns
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.presentention.ui.base.BasePresenter

class CheckinPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase
) : BasePresenter<CheckinView>() {

    fun checkin(eventId: String?, name: String, email: String){
        if(validateFields(name, email)){
            view?.showLoader()
        }
    }

    private fun validateFields(name: String, email: String): Boolean {
        when {
            name.isBlank() -> {
                view?.showError("Informe um nome válido")
                return false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                view?.showError("Informe um email válido")
                return false
            }
        }
        return true
    }

}