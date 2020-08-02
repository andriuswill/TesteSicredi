package com.andriuswill.testesicredi.presentantion.ui.eventDetail.checkinDialog

import android.content.Context
import android.util.Patterns
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.data.models.People
import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.domain.usecases.RequestExceptionUseCase
import com.andriuswill.testesicredi.presentantion.base.BasePresenter
import kotlinx.coroutines.launch

class CheckinPresenter(
    private val context: Context,
    private val eventsUseCase: EventsUseCase,
    private val requestExceptionUseCase: RequestExceptionUseCase
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

                    view?.onCheckedin(
                        People(
                            id = "",
                            eventId = eventId!!,
                            name = name,
                            picture = ""
                        )
                    )
                }

            } catch (e: Exception) {
                view?.showError(
                    requestExceptionUseCase.treatException(e)
                )
            } finally {
                view?.hideLoader()
            }
        }
    }

    private fun validateFields(name: String, email: String): Boolean {
        when {
            name.isBlank() -> {
                view?.showError(context.getString(R.string.error_name))
                return false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                view?.showError(context.getString(R.string.error_email))
                return false
            }
        }
        return true
    }

}