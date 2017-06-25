package com.omatt.fdlsandbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.firebase.AppInviteHelper;
import com.omatt.fdlsandbox.utils.AppController;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private final int REQUEST_INVITE = 0;

    @Inject FirebaseDynamicLinks mFDL;

    @OnClick(R.id.btn_app_invite_send) void sendAppInvite(){
        Log.i(TAG, "Send App Invite Clicked!");
        startActivityForResult(new AppInviteHelper().appInviteTemplate(this), REQUEST_INVITE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppController.getComponent(this).inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);

        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                // Get the invitation IDs of all sent messages
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                for (String id : ids) {
                    Log.d(TAG, "onActivityResult: sent invitation " + id);
                }
            } else {
                // Sending failed or it was canceled, show failure message to the user
                // [START_EXCLUDE]
                Log.e(TAG, "onActivityResult: Sending Invite Failed");
//                showMessage(getString(R.string.send_failed));
                // [END_EXCLUDE]
            }
        }
    }
}
