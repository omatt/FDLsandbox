package com.omatt.fdlsandbox.modules.deeplink

import android.content.Intent
import android.util.Log
import com.google.firebase.appinvite.FirebaseAppInvite
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import java.lang.Exception

/**
 * Created by omarmatthew on 9/16/2017.
 * DeepLinkActivity Presenter
 */
class DeepLinkPresenter : DeepLinkContract.Presenter {
    private val TAG = "DeepLinkPresenter"
    lateinit var deepLinkView : DeepLinkContract.View
    override fun takeView(view: DeepLinkContract.View) {
        deepLinkView = view
    }

    override fun dropView() {
        deepLinkView
    }

    override fun processDeepLink(intent: Intent) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnSuccessListener {
            pendingDynamicLinkData: PendingDynamicLinkData? ->
            if (pendingDynamicLinkData == null) {
                Log.w(TAG, "No deep link found")
                return@addOnSuccessListener
            }

            // Get deep link
            val deepLink = pendingDynamicLinkData.link
            Log.i(TAG, "Deep Link: $deepLink")
            deepLinkView.updateDeepLink(deepLink.toString())

            // Fetch referrer id
            if (deepLink != null) {
                if (deepLink.getBooleanQueryParameter("customId", false))
                    deepLink.getQueryParameter("customId")?.let { deepLinkView.updateReferrerId(it) }
            }

            // Get inviteId
            val invite = FirebaseAppInvite.getInvitation(pendingDynamicLinkData)
            val invitationId: String = invite.invitationId
            Log.i(TAG, "Invitation ID: $invitationId")
            deepLinkView.updateInviteId(invitationId)
        }.addOnFailureListener { exception: Exception ->
            Log.w(TAG, "processDeepLink error: $exception")
        }
    }
}