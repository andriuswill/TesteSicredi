package com.andriuswill.testesicredi.presentention.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andriuswill.testesicredi.R
import com.andriuswill.testesicredi.presentention.ui.base.BasePresenter
import com.andriuswill.testesicredi.presentention.ui.base.RootActivity
import org.kodein.di.generic.instance

class MainActivity: RootActivity<MainView>(), MainView {

    override val layoutResourceId = R.layout.activity_main

    override val presenter: MainPresenter by instance()

    override fun initializeUI() {
        presenter.getEvents()
    }

    override fun initializePresenter() {
        presenter.start(this)
    }

    override fun showError(message: Int) {

    }

}