package com.andriuswill.testesicredi.presentantion.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

abstract class RootActivity <V : BaseView> : AppCompatActivity(), KodeinAware, BaseView {

    protected abstract val layoutResourceId: Int
    protected abstract val presenter: BasePresenter<V>
    override val kodein by kodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        initializePresenter()
        initializeUI()
    }

    protected abstract fun initializeUI()

    protected abstract fun initializePresenter()

    override fun onPause() {
        super.onPause()
        presenter.pause()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

}
