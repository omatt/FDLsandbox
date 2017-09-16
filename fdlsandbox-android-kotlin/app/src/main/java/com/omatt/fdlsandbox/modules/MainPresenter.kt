package com.omatt.fdlsandbox.modules

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import com.google.firebase.appinvite.FirebaseAppInvite
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import com.google.firebase.dynamiclinks.ShortDynamicLink
import com.omatt.fdlsandbox.AppController
import com.omatt.fdlsandbox.firebase.DynamicLinkHelper
import java.lang.Exception

/**
 * Created by omarmatthew on 9/16/2017.
 * MainActivity Presenter
 */
class MainPresenter : MainContract.Presenter {
    private val TAG = "MainPresenter"
    lateinit var mainView: MainContract.View

    /**
     * Fetch view from MainActivity
     * @param view MainContract.View
     */
    override fun takeView(view: MainContract.View) {
        mainView = view
    }

    /**
     * Drop view
     * unsure if still necessary since there's JVM garbage collection
     */
    override fun dropView() {
        mainView
    }

    /**
     * Process received Dynamic Link
     * @param intent Intent
     */
    override fun processDeepLink(intent: Intent) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnSuccessListener({ pendingDynamicLinkData: PendingDynamicLinkData? ->
            if (pendingDynamicLinkData == null) {
                Log.w(TAG, "No deep link found")
                return@addOnSuccessListener
            }

            // Get deep link
            val deepLink = pendingDynamicLinkData.link
            Log.i(TAG, "Deep Link: $deepLink")
            Toast.makeText(AppController.instance, "Deep Link received: $deepLink", Toast.LENGTH_SHORT).show()

            // Get inviteId
            val invite = FirebaseAppInvite.getInvitation(pendingDynamicLinkData)
            val invitationId: String = invite.invitationId
            Log.i(TAG, "Invitation ID: $invitationId")
            Toast.makeText(AppController.instance, "Invitation ID: $invitationId", Toast.LENGTH_SHORT).show()
        }).addOnFailureListener({ exception: Exception ->
            Toast.makeText(AppController.instance, "Dynamic Link failure: $exception", Toast.LENGTH_SHORT).show()
        })
    }

    /**
     * Build long and short dynamic links
     * @param context Context
     */
    override fun buildDynamicLink(context: Context) {
        val fdlBuilder = DynamicLinkHelper().dynamicLinkBuilder(context)
        val longFDL = fdlBuilder.buildDynamicLink().uri.toString()

        mainView.updateDynamicLinkLong(longFDL)
        Log.i(TAG, "dynamicLinkBuilder long FDL: $longFDL")
        fdlBuilder.buildShortDynamicLink().addOnSuccessListener({ shortDynamicLink: ShortDynamicLink? ->
            if (shortDynamicLink != null) {
                val shortLink = shortDynamicLink.shortLink.toString()
                val debugLink = shortDynamicLink.previewLink.toString()
                mainView.updateDynamicLinkShort(shortLink)
                Log.i(TAG, "dynamicLinkBuilder short FDL: $shortLink")
                Log.i(TAG, "dynamicLinkBuilder preview FDL: $debugLink")
            }
        }).addOnFailureListener({ exception: Exception ->
            Log.e(TAG, "dynamicLinkBuilder Error: $exception")
        })
    }
}