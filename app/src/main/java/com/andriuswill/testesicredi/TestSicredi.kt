package com.andriuswill.testesicredi

import android.app.Application
import com.andriuswill.testesicredi.data.network.ApiBuilder
import com.andriuswill.testesicredi.data.network.AppServices
import com.andriuswill.testesicredi.domain.di.presentersModule
import com.andriuswill.testesicredi.domain.di.useCaseModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class TestSicredi: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        bind<ApiBuilder>() with singleton { ApiBuilder() }
        bind<AppServices>() with singleton { AppServices.instance(instance()) }

        import(androidXModule(this@TestSicredi))
        import(presentersModule)
        import(useCaseModule)
    }

}