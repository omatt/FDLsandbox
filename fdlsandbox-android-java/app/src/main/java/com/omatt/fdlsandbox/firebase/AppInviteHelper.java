package com.omatt.fdlsandbox.firebase;

import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.omatt.fdlsandbox.R;
import com.omatt.fdlsandbox.utils.AppController;

/**
 * Created by omarmatthew on 6/25/17.
 * Class containing all necessary methods that uses Firebase App Invites
 */

public class AppInviteHelper {
    private final String TAG = "AppInviteHelper";

    /**
     * Returns Invite build template
     *
     * @param deepLink String
     * @return Intent
     */
    public Intent appInviteTemplate(String deepLink) {
        return new AppInviteInvitation.IntentBuilder(AppController.getsInstance().getString(R.string.invitation_title))
                .setMessage(AppController.getsInstance().getString(R.string.invitation_message))
                .setDeepLink(Uri.parse(deepLink))
                .setCustomImage(Uri.parse(AppController.getsInstance().getString(R.string.invitation_custom_image)))
                .setCallToActionText(AppController.getsInstance().getString(R.string.invitation_cta))
                .build();
    }
}
