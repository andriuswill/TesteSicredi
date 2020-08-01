package com.andriuswill.testesicredi.domain.di

import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.domain.usecases.EventsUseCaseImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val useCaseModule = Kodein.Module(name = "UseCase Module") {
    bind<EventsUseCase>() with singleton { EventsUseCaseImpl(instance()) }
}