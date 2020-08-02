package com.andriuswill.testesicredi.domain.di

import com.andriuswill.testesicredi.domain.usecases.EventsUseCase
import com.andriuswill.testesicredi.domain.usecases.EventsUseCaseImpl
import com.andriuswill.testesicredi.domain.usecases.RequestExceptionUseCase
import com.andriuswill.testesicredi.domain.usecases.RequestExceptionUseCaseImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val useCaseModule = Kodein.Module(name = "UseCase Module") {
    bind<EventsUseCase>() with singleton { EventsUseCaseImpl(instance()) }
    bind<RequestExceptionUseCase>() with singleton { RequestExceptionUseCaseImpl(instance()) }
}