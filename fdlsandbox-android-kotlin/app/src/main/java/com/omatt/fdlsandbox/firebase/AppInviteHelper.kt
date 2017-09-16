package com.omatt.fdlsandbox.firebase

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.google.android.gms.appinvite.AppInviteInvitation
import com.omatt.fdlsandbox.R

/**
 * Created by omarmatthew on 9/16/2017.
 */
class AppInviteHelper {
    /**
     * Returns Invite build template
     * @param context Context
     * @return Intent
     */
    fun appInviteTemplate(context : Context) : Intent {
        return AppInviteInvitation.IntentBuilder(context.getString(R.string.invitation_title))
                .setMessage(context.getString(R.string.invitation_message))
                .setDeepLink(Uri.parse(context.getString(R.string.invitation_deep_link)))
                .setCustomImage(Uri.parse(context.getString(R.string.invitation_custom_image)))
                .setCallToActionText(context.getString(R.string.invitation_cta))
                .build()
    }
}