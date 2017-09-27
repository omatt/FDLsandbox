package com.omatt.fdlsandbox.modules

import android.app.Activity
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
import com.omatt.fdlsandbox.R
import com.omatt.fdlsandbox.firebase.AppInviteHelper
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

    override fun sendAppInvite(activity: Activity, resultCode: Int) {
        val link = activity.getString(R.string.deep_link) + "?customId=" + "sampleCustomId"
        FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(link))
                .setDynamicLinkDomain(activity.getString(R.string.dynamic_link_domain))
                .setAndroidParameters(
                        DynamicLink.AndroidParameters.Builder(activity.packageName)
                                .setMinimumVersion(8)
                                .build())
                .setIosParameters(
                        DynamicLink.IosParameters.Builder("com.example.ios")
                                .setAppStoreId("123456789")
                                .setMinimumVersion("1.0.1")
                                .build())
                .buildShortDynamicLink()
                .addOnSuccessListener({ shortDynamicLink: ShortDynamicLink? ->
                    if (shortDynamicLink != null) {
                        Log.i(TAG, "sendAppInvite shortLink: ${shortDynamicLink.shortLink}")
                        Log.i(TAG, "sendAppInvite debug link: ${shortDynamicLink.previewLink}")
                        activity.startActivityForResult(AppInviteHelper().appInviteTemplate(activity, shortDynamicLink.shortLink.toString()), resultCode)
                    }
                })

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
        val fdlBuilder = DynamicLinkHelper().dynamicLinkBuilderTest(context)
        val longFDL = fdlBuilder.buildDynamicLink().uri.toString()

        mainView.updateDynamicLinkLong(longFDL)
        Log.i(TAG, "dynamicLinkBuilder long FDL: $longFDL")
        fdlBuilder.buildShortDynamicLink()
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        Log.i(TAG, "dynamicLinkBuilder success short FDL ${task.result.shortLink}")
                        Log.i(TAG, "dynamicLinkBuilder success preview FDL ${task.result.previewLink}")
                    } else Log.e(TAG, "dynamicLinkBuilder failed")
                })
                .addOnSuccessListener({ shortDynamicLink: ShortDynamicLink? ->
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