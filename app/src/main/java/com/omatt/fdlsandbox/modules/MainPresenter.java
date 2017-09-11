package com.omatt.fdlsandbox.modules;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.appinvite.FirebaseAppInvite;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.firebase.DynamicLinkHelper;
import com.omatt.fdlsandbox.utils.AppController;

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
}
