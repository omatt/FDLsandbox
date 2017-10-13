package com.omatt.fdlsandbox.modules.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.firebase.appinvite.FirebaseAppInvite;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;

/**
 * Created by omarmatthew on 6/27/17.
 * DeepLinkActivity Presenter
 */

public class DeepLinkPresenter implements DeepLinkContract.Presenter {
    private final String TAG = "DeepLinkPresenter";
    private DeepLinkContract.View deepLinkView;

    @Override
    public void takeView(DeepLinkContract.View view) {
        deepLinkView = view;
    }

    @Override
    public void dropView() {
        deepLinkView = null;
    }

    @Override
    public void processDeepLink(Intent intent) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnSuccessListener(data -> {
            if (data == null) {
                Log.d(TAG, "getInvitation: no data");
                return;
            }

            // Get the deep link
            Uri deepLink = data.getLink();
            Log.i(TAG, "Deep Link: " + deepLink);
            deepLinkView.updateDeepLink(deepLink.toString());

            // Fetch referrer id
            if (deepLink.getBooleanQueryParameter("customId", false))
                deepLinkView.updateReferrerId(deepLink.getQueryParameter("customId"));

            // Extract invite
            FirebaseAppInvite invite = FirebaseAppInvite.getInvitation(data);
            if (invite != null) {
                String invitationId = invite.getInvitationId();
                Log.i(TAG, "Invitation ID: " + invitationId);
                deepLinkView.updateInviteId(invitationId);
            }
        }).addOnFailureListener(e -> Log.w(TAG, "getDynamicLink:onFailure", e));
    }
}
