package com.omatt.fdlsandbox.modules

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.omatt.fdlsandbox.BasePresenter
import com.omatt.fdlsandbox.BaseView

/**
 * Created by omarmatthew on 9/16/2017.
 * Main Contract
 */
interface MainContract {
    interface View : BaseView<Presenter> {
        fun updateDynamicLinkLong(link: String)
        fun updateDynamicLinkShort(link: String)
    }

    interface Presenter : BasePresenter<View> {
        fun sendAppInvite(activity: Activity, resultCode : Int)
        fun processDeepLink(intent: Intent)
        fun buildDynamicLink(context: Context)
    }
}