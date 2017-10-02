package com.omatt.fdlsandbox.modules

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.gms.appinvite.AppInviteInvitation
import com.google.firebase.analytics.FirebaseAnalytics
import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.R
import com.omatt.fdlsandbox.firebase.AnalyticsHelper
import javax.inject.Inject

/**
 * Class : ParentClass(), Interface
 * Overriding rules, inheritance
 * https://kotlinlang.org/docs/reference/classes.html#overriding-rules
 */
class MainActivity : AppCompatActivity(), MainContract.View {
    private val TAG = "MainActivity"
    private val REQUEST_INVITE = 0

    /**
     * lateinit - Late-initialized Properties
     * https://kotlinlang.org/docs/reference/properties.html#late-initialized-properties
     */
    @Inject
    lateinit var mainPresenter: MainPresenter
    @Inject
    lateinit var firebaseAnalytics: FirebaseAnalytics

    @BindView(R.id.textView_fdl_long)
    lateinit var textViewFDLLong: TextView
    @BindView(R.id.textView_fdl_short)
    lateinit var textViewFDLShort: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_main)
        ButterKnife.bind(this)
        AppController.component.inject(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                // Get the invitation IDs of all sent messages
                val ids = AppInviteInvitation.getInvitationIds(resultCode, data)
                for (id in ids) {
                    Log.d(TAG, "onActivityResult: sent invitation " + id)
                }
            } else // Sending failed or it was canceled, show failure message to the user
                Log.e(TAG, "onActivityResult: Sending Invite Failed")
        }
    }

    /**
     * Take MainActivity view onResume
     */
    override fun onResume() {
        super.onResume()
        mainPresenter.takeView(this)

        mainPresenter.processDeepLink(intent)
    }

    /**
     * Drop MainActivity view onDestroy
     */
    override fun onDestroy() {
        mainPresenter.dropView()
        super.onDestroy()
    }

    @OnClick(R.id.btn_app_invite_send)
    fun sendAppInvite() {
        Log.i(TAG, "Send App Invite Clicked!")
        firebaseAnalytics.logEvent("generateFDL", AnalyticsHelper().logEventActionBuilder("btn_app_invite_send"))
        mainPresenter.sendAppInvite(this, REQUEST_INVITE)
    }

    @OnClick(R.id.btn_gen_fdl)
    fun generateFDL() {
        Log.i(TAG, "Generate FDL Clicked!")
        firebaseAnalytics.logEvent("generateFDL", AnalyticsHelper().logEventActionBuilder("btn_gen_fdl"))
        mainPresenter.buildDynamicLink(this)
    }

    /**
     * Update long dynamic link
     */
    override fun updateDynamicLinkLong(link: String) {
        textViewFDLLong.text = link
//        textView_fdl_long.text = link
    }

    /**
     * Update short dynamic link
     */
    override fun updateDynamicLinkShort(link: String) {
        textViewFDLShort.text = link
//        textView_fdl_short.text = link
    }
}
