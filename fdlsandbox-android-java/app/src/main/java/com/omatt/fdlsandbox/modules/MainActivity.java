package com.omatt.fdlsandbox.modules;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.R;
import com.omatt.fdlsandbox.firebase.AnalyticsHelper;
import com.omatt.fdlsandbox.firebase.AppInviteHelper;
import com.omatt.fdlsandbox.utils.AppController;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    private final String TAG = "MainActivity";
    private final int REQUEST_INVITE = 0;

    @BindView(R.id.textView_fdl_long)
    TextView textViewFDLLong;
    @BindView(R.id.textView_fdl_short)
    TextView textViewFDLShort;

    @Inject
    FirebaseDynamicLinks firebaseDynamicLinks;
    @Inject
    FirebaseAnalytics firebaseAnalytics;
    @Inject MainPresenter mainPresenter;

    @OnClick(R.id.btn_app_invite_send)
    void sendAppInvite() {
        firebaseAnalytics.logEvent("generateFDL",
                new AnalyticsHelper().logEventActionBuilder("btn_app_invite_send"));
        Log.i(TAG, "Send App Invite Clicked!");
        mainPresenter.sendAppInvite(this, REQUEST_INVITE);
    }

    @OnClick(R.id.btn_gen_fdl)
    void generateFDL() {
        firebaseAnalytics.logEvent("generateFDL",
                new AnalyticsHelper().logEventActionBuilder("btn_gen_fdl"));
        Log.i(TAG, "Generate FDL Clicked!");
        mainPresenter.buildDynamicLink();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
        ButterKnife.bind(this);
        AppController.getComponent(this).inject(this);

        mainPresenter.processDeepLink(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        mainPresenter.dropView();
        super.onDestroy();
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

    @Override
    public MainActivity getMainActivity() {
        return this;
    }

    @Override
    public void updateDynamicLinkLong(String link) {
        textViewFDLLong.setText(link);
    }

    @Override
    public void updateDynamicLinkShort(String link) {
        textViewFDLShort.setText(link);
    }
}
