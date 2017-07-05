package com.omatt.fdlsandbox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.appinvite.FirebaseAppInvite;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.omatt.fdlsandbox.firebase.DynamicLinkHelper;
import com.omatt.fdlsandbox.modules.DeepLinkPresenter;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
     *
     * @param intent           Intent
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

    public void processDeepLink(final Context context, Intent intent) {
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

    /**
     * Generate long and short Dynamic Links
     * @param textViewFDLLong {@link TextView}
     * @param textViewFDLShort {@link TextView}
     */
    public void dynamicLinkBuilder(final TextView textViewFDLLong, final TextView textViewFDLShort) {
        DynamicLink.Builder fdlBuilder = new DynamicLinkHelper().dynamicLinkBuilder(this);
        String longFDL = "";
        try {
            longFDL = URLDecoder.decode(fdlBuilder.buildDynamicLink().getUri().toString(), "utf-8");
        } catch (Exception e){
            FirebaseCrash.report(e);    // Report Exception
            Log.e(TAG, "dynamicLinkBuilder URL decode error " + e);
        }
        textViewFDLLong.setText(longFDL);
        Log.i(TAG, "dynamicLinkBuilder long FDL: " + longFDL);
        FirebaseDynamicLinks.getInstance().createDynamicLink().setLongLink(Uri.parse(longFDL)).buildShortDynamicLink()
                .addOnCompleteListener(this, new OnCompleteListener<ShortDynamicLink>() {
                    @Override
                    public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                        if (task.isSuccessful()) {
                            // Short link created
                            Uri shortLink = task.getResult().getShortLink();
                            textViewFDLShort.setText(shortLink.toString());
                            Uri flowchartLink = task.getResult().getPreviewLink();
                            Log.i(TAG, "dynamicLinkBuilder short FDL: " + shortLink.toString());
                            Log.i(TAG, "dynamicLinkBuilder preview FDL: " + flowchartLink.toString());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "dynamicLinkBuilder Error: " + e);
            }
        });

    }
}
