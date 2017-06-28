package com.omatt.fdlsandbox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.appinvite.FirebaseAppInvite;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.omatt.fdlsandbox.modules.DeepLinkPresenter;

/**
 * Created by omarmatthew on 6/27/17.
 * BaseActivity
 */

public class BaseActivity extends AppCompatActivity {
    private final String TAG = "BaseActivity";

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Display deep link and invite id on TextView
     * @param intent Intent
     * @param textViewDeepLink TextView
     * @param textViewInviteId TextView
     */
    public void processReferralIntent(Intent intent, TextView textViewDeepLink, TextView textViewInviteId) {
        // Check for App Invite invitations and launch deep-link activity if possible.
        // Requires that an Activity is registered in AndroidManifest.xml to handle
        // deep-link URLs.
        final DeepLinkPresenter deepLinkPresenter = new DeepLinkPresenter(textViewDeepLink, textViewInviteId);
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent)
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData data) {
                        if (data == null) {
                            Log.d(TAG, "getInvitation: no data");
                            return;
                        }

                        // Get the deep link
                        Uri deepLink = data.getLink();
                        Log.i(TAG, "Deep Link: " + deepLink);
                        deepLinkPresenter.setDeepLink(deepLink.toString());

                        // Extract invite
                        FirebaseAppInvite invite = FirebaseAppInvite.getInvitation(data);
                        if (invite != null) {
                            String invitationId = invite.getInvitationId();
                            Log.i(TAG, "Invitation ID: " + invitationId);
                            deepLinkPresenter.setInviteId(invitationId);
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "getDynamicLink:onFailure", e);
                    }
                });
    }

    public void processDeepLink(final Context context, Intent intent){
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent)
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData data) {
                        if (data == null) {
                            Log.d(TAG, "getInvitation: no data");
                            return;
                        }

                        // Get the deep link
                        Uri deepLink = data.getLink();
                        Log.i(TAG, "Deep Link: " + deepLink);
                        Toast.makeText(context, "Deep Link received: " + deepLink, Toast.LENGTH_SHORT).show();

                        // Extract invite
                        FirebaseAppInvite invite = FirebaseAppInvite.getInvitation(data);
                        if (invite != null) {
                            String invitationId = invite.getInvitationId();
                            Log.i(TAG, "Invitation ID: " + invitationId);
                            Toast.makeText(context, "Invitation ID: " + invitationId, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Dynamic Link failure: " + e, Toast.LENGTH_SHORT).show();
                        Log.w(TAG, "getDynamicLink:onFailure", e);
                    }
                });
    }
}
