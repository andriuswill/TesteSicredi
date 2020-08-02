package com.andriuswill.testesicredi.domain.di

import com.andriuswill.testesicredi.presentantion.ui.eventDetail.EventDetailPresenter
import com.andriuswill.testesicredi.presentantion.ui.eventDetail.checkinDialog.CheckinPresenter
import com.andriuswill.testesicredi.presentantion.ui.main.MainPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val presentersModule = Kodein.Module(name = "Presenter Module") {
    bind<MainPresenter>() with provider { MainPresenter(instance(), instance(), instance()) }
    bind<EventDetailPresenter>() with provider { EventDetailPresenter(instance(), instance(), instance()) }
    bind<CheckinPresenter>() with provider { CheckinPresenter(instance(), instance(), instance()) }
}