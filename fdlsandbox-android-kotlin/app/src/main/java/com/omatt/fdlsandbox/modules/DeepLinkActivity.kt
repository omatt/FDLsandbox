package com.omatt.fdlsandbox.modules

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.R
import javax.inject.Inject

/**
 * Created by omarmatthew on 9/16/2017.
 * Handles incoming dynamic links from app invites {host}/invites
 */
class DeepLinkActivity : AppCompatActivity(), DeepLinkContract.View {
    private val TAG = "DeepLinkActivity"

    @Inject lateinit var deepLinkPresenter: DeepLinkPresenter

    @BindView(R.id.textView_deep_link)
    lateinit var textViewDeepLink: TextView
    @BindView(R.id.textView_invite_id)
    lateinit var textViewInviteId: TextView
    @BindView(R.id.textView_referrer_id)
    lateinit var textViewReferrerId: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_deep_link)
        ButterKnife.bind(this)
        AppController.component.inject(this)

        deepLinkPresenter.processDeepLink(intent)
    }

    override fun onResume() {
        super.onResume()
        deepLinkPresenter.takeView(this)
    }

    override fun onDestroy() {
        deepLinkPresenter.dropView()
        super.onDestroy()
    }

    @OnClick(R.id.btn_app_invite_ok)
    fun onClickOK() {
        finish()
    }

    override fun updateDeepLink(deepLink: String) {
        textViewDeepLink.text = deepLink
    }

    override fun updateInviteId(inviteId: String) {
        textViewInviteId.text = inviteId
    }

    override fun updateReferrerId(referrerId: String) {
        textViewReferrerId.text = referrerId
    }
}