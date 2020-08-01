package com.andriuswill.testesicredi.domain.di

import com.andriuswill.testesicredi.presentention.ui.main.MainPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val presentersModule = Kodein.Module(name = "Presenter Module") {
    bind<MainPresenter>() with provider { MainPresenter(instance()) }
}