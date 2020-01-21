package com.omatt.fdlsandbox.modules.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnCheckedChanged
import butterknife.OnClick
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.google.android.gms.appinvite.AppInviteInvitation
import com.google.firebase.analytics.FirebaseAnalytics
import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.BuildConfig
import com.omatt.fdlsandbox.R
import com.omatt.fdlsandbox.firebase.AnalyticsHelper
import com.omatt.fdlsandbox.modules.inappbrowser.InAppBrowserActivity
import io.fabric.sdk.android.Fabric
import javax.inject.Inject

/**
 * Class : ParentClass(), Interface
 * Overriding rules, inheritance
 * https://kotlinlang.org/docs/reference/classes.html#overriding-rules
 */
class MainActivity : AppCompatActivity(), MainContract.View {
    private val TAG = "MainActivity"
    private val REQUEST_INVITE = 0
    var catchCrash = false

    /**
     * lateinit - Late-initialized Properties
     * https://kotlinlang.org/docs/reference/properties.html#late-initialized-properties
     */
    @Inject
    lateinit var mainPresenter: MainPresenter

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

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

//        Fabric.with(this, Crashlytics())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_CANCELED && data != null)
            if (requestCode == REQUEST_INVITE) {
                if (resultCode == RESULT_OK) {
                    // Get the invitation IDs of all sent messages
                    val ids = AppInviteInvitation.getInvitationIds(resultCode, data)
                    for (id in ids) {
                        Log.d(TAG, "onActivityResult: sent invitation $id")
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
        mainPresenter.buildDynamicLink(this, false)
    }

    @OnClick(R.id.btn_web_view)
    fun openInAppBrowser() {
        val intent = Intent(this, InAppBrowserActivity::class.java)
        val shortFDL = textViewFDLShort.text.toString()
        Log.i(TAG, "shortFDL $shortFDL txt_fdl_short ${getString(R.string.txt_fdl_short)}")
        if (shortFDL != (getString(R.string.txt_fdl_short))) {
            intent.putExtra("KEY_FDL", shortFDL)
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.txt_fdl_short_empty), Toast.LENGTH_SHORT).show()
        }
    }

    @OnClick(R.id.btn_force_crash)
    fun onClickCrash() {
        Log.i(TAG, "Clicked Crash; catch? $catchCrash")
        mainPresenter.forceCrash(this, catchCrash)
    }

    @OnCheckedChanged(R.id.switch_catch_crash)
    fun onSwitchChanged(checked: Boolean) {
        Log.i(TAG, "switch $checked")
        catchCrash = checked
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
