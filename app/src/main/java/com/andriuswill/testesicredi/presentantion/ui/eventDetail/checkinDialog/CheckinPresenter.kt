package com.andriuswill.testesicredi.presentantion.ui.eventDetail.checkinDialog

import android.content.Context
import android.util.Patterns
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.presentantion.base.BasePresenter
import kotlinx.coroutines.launch

class CheckinPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase
) : BasePresenter<CheckinView>() {

    fun checkin(eventId: String?, name: String, email: String) {
        launch(coroutineContext) {
            try {
                view?.showLoader()
                if (validateFields(name, email)) {
                    eventsUseCase.checkinAsync(
                        eventId = eventId!!,
                        email = email,
                        name = name
                    ).await()
                }
            } catch (e: Exception) {
                view?.showError(
                    context.resources.getString(R.string.default_error_message)
                )
            } finally {
                view?.hideLoader()
            }
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