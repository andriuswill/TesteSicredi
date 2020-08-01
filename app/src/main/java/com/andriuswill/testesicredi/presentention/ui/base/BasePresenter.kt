package com.andriuswill.testesicredi.presentention.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<V : BaseView> : CoroutineScope {
    private val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    var view: V? = null

    fun start(v: V?) {
        this.view = v
        if (v == null) {
            throw RuntimeException()
        }
        this.initialize()
    }

    open fun initialize() {}

    open fun resume() {}

    open fun pause() {}

    open fun stop() {}

    open fun destroy() {}

}