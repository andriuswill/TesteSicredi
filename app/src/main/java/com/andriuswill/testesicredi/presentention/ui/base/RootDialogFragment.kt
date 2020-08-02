package com.andriuswill.testesicredi.presentention.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein

abstract class RootDialogFragment<V : BaseView> : DialogFragment(), KodeinAware, BaseView {

    protected abstract val layoutResourceId: Int
    protected abstract val presenter: BasePresenter<V>
    override val kodein by kodein()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {
        return inflater.inflate(layoutResourceId, container, false)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        initializePresenter()
    }

    protected abstract fun initializeUI()

    protected abstract fun initializePresenter()

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

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