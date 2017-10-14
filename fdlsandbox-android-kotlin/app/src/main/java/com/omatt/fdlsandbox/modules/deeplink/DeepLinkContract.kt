package com.omatt.fdlsandbox.modules.deeplink

import android.content.Intent
import com.omatt.fdlsandbox.BasePresenter
import com.omatt.fdlsandbox.BaseView

/**
 * Created by omarmatthew on 9/16/2017.
 */
interface DeepLinkContract {
    interface View : BaseView<Presenter> {
        fun updateDeepLink(deepLink: String)

        fun updateInviteId(inviteId: String)

        fun updateReferrerId(referrerId: String)
    }

    interface Presenter : BasePresenter<View> {
        fun processDeepLink(intent: Intent)
    }
}