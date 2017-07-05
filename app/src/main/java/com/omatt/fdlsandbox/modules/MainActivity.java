package com.omatt.fdlsandbox.modules;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.BaseActivity;
import com.omatt.fdlsandbox.R;
import com.omatt.fdlsandbox.firebase.AppInviteHelper;
import com.omatt.fdlsandbox.utils.AppController;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private final String TAG = "MainActivity";
    private final int REQUEST_INVITE = 0;

    @BindView(R.id.textView_fdl_long) TextView textViewFDLLong;
    @BindView(R.id.textView_fdl_short) TextView textViewFDLShort;

    @Inject FirebaseDynamicLinks firebaseDynamicLinks;
    @Inject
    FirebaseAnalytics firebaseAnalytics;

    @OnClick(R.id.btn_app_invite_send) void sendAppInvite(){
        Log.i(TAG, "Send App Invite Clicked!");
        // Send AppInvite Intent Builder
        startActivityForResult(new AppInviteHelper().appInviteTemplate(this), REQUEST_INVITE);
    }

    @OnClick(R.id.btn_gen_fdl) void generateFDL(){
        dynamicLinkBuilder(textViewFDLLong, textViewFDLShort);
    }

    @Override
    public void processDeepLink(Context context, Intent intent) {
        super.processDeepLink(context, intent);
    }

    @Override
    public void dynamicLinkBuilder(TextView textViewFDLLong, TextView textViewFDLShort) {
        super.dynamicLinkBuilder(textViewFDLLong, textViewFDLShort);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        ButterKnife.bind(this);
        AppController.getComponent(this).inject(this);

        processDeepLink(this, getIntent());
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
