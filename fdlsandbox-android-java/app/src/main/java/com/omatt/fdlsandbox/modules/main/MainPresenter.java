package com.omatt.fdlsandbox.modules.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.appinvite.FirebaseAppInvite;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.R;
import com.omatt.fdlsandbox.firebase.AppInviteHelper;
import com.omatt.fdlsandbox.firebase.DynamicLinkHelper;
import com.omatt.fdlsandbox.AppController;

/**
 * Created by omarmatthew on 6/27/17.
 * MainActivity Presenter
 */

public class MainPresenter implements MainContract.Presenter{
    private final String TAG = "MainPresenter";
    private MainContract.View mainView;

    @Override
    public void takeView(MainContract.View view) {
        mainView = view;
    }

    @Override
    public void dropView() {
        mainView = null;
    }

    @Override
    public void sendAppInvite(Activity activity, int resultCode) {
        String link = activity.getString(R.string.deep_link) + "?customId=" + "sampleCustomId";
        FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(link))
                .setDynamicLinkDomain(activity.getString(R.string.dynamic_link_domain))
                .setAndroidParameters(
                        new DynamicLink.AndroidParameters.Builder(activity.getPackageName())
                                .setMinimumVersion(8)
                                .build())
                .setIosParameters(
                        new DynamicLink.IosParameters.Builder("com.example.ios")
                                .setAppStoreId("123456789")
                                .setMinimumVersion("1.0.1")
                                .build())
                .buildShortDynamicLink()
                .addOnSuccessListener(shortDynamicLink -> {
                    Log.i(TAG, "sendAppInvite shortLink: " + shortDynamicLink.getShortLink().toString());
                    Log.i(TAG, "sendAppInvite debug link: " + shortDynamicLink.getPreviewLink().toString());
                    activity.startActivityForResult(new AppInviteHelper().appInviteTemplate(shortDynamicLink.getShortLink().toString()), resultCode);
                });
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
            Toast.makeText(AppController.getsInstance(), "Deep Link received: " + deepLink, Toast.LENGTH_SHORT).show();

            // Extract invite
            FirebaseAppInvite invite = FirebaseAppInvite.getInvitation(data);
            if (invite != null) {
                String invitationId = invite.getInvitationId();
                Log.i(TAG, "Invitation ID: " + invitationId);
                Toast.makeText(AppController.getsInstance(), "Invitation ID: " + invitationId, Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(AppController.getsInstance(), "Dynamic Link failure: " + e, Toast.LENGTH_SHORT).show();
            Log.w(TAG, "getDynamicLink:onFailure", e);
        });
    }

    @Override
    public void buildDynamicLink() {
        DynamicLink.Builder fdlBuilder = new DynamicLinkHelper().dynamicLinkBuilder(AppController.getsInstance());
        String longFDL = fdlBuilder.buildDynamicLink().getUri().toString();
//        try {
//            longFDL = URLDecoder.decode(fdlBuilder.buildDynamicLink().getUri().toString(), "utf-8");
//        } catch (Exception e){
//            FirebaseCrash.report(e);    // Report Exception
//            Log.e(TAG, "dynamicLinkBuilder URL decode error " + e);
//        }
        mainView.updateDynamicLinkLong(longFDL);
        Log.i(TAG, "dynamicLinkBuilder long FDL: " + longFDL);
        fdlBuilder.buildShortDynamicLink().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Short link created
                Uri shortLink = task.getResult().getShortLink();
                mainView.updateDynamicLinkShort(shortLink.toString());
                Uri flowchartLink = task.getResult().getPreviewLink();
                Log.i(TAG, "dynamicLinkBuilder short FDL: " + shortLink.toString());
                Log.i(TAG, "dynamicLinkBuilder preview FDL: " + flowchartLink.toString());
            }
        }).addOnFailureListener(e -> Log.e(TAG, "dynamicLinkBuilder Error: " + e));
    }

    @Override
    public void forceCrash(boolean catchCrash) {
        // Log that crash button was clicked. This version of Crash.log() will include the
        // message in the crash report as well as show the message in logcat.
//        FirebaseCrash.logcat(Log.INFO, TAG, "Crash button clicked");

        // If catchCrashCheckBox is checked catch the exception and report is using
        // Crash.report(). Otherwise throw the exception and let Firebase Crash automatically
        // report the crash.
//        if(catchCrash) {
//            try {
//                throw new NullPointerException();
//            } catch (NullPointerException ex) {
//                // [START log_and_report]
//                FirebaseCrash.logcat(Log.ERROR, TAG, "NPE caught");
//                FirebaseCrash.log("My Exception in device details");
////                FirebaseCrash.report(ex);
//                FirebaseCrash.report(new Exception(ex.getMessage()+" - "+ex.getCause()));
//                // [END log_and_report]
//            }
//        } else throw new NullPointerException();

        if(catchCrash) {
            try {
                Log.e(TAG, "Can you do this? " + 1/0);
            } catch (Exception ex) {
                // Crashlytics
                Crashlytics.logException(ex);
            }
        } else Log.e(TAG, "Can you do this exp? " + 1/0);
    }
}
