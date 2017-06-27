package com.omatt.fdlsandbox.modules;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.BaseActivity;
import com.omatt.fdlsandbox.R;
import com.omatt.fdlsandbox.utils.AppController;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by omarmatthew on 6/24/17.
 * DeepLinkActivity handles FDL deep links
 */

public class DeepLinkActivity extends BaseActivity{
    private final String TAG = "DeepLinkActivity";
    @BindView(R.id.textView_deep_link)
    TextView textViewDeepLink;
    @BindView(R.id.textView_invite_id)
    TextView textViewInviteId;

    @OnClick(R.id.btn_app_invite_ok)
    void onClickedOk() {
        finish();
    }

    @Inject
    FirebaseDynamicLinks mDynamicLinks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_deep_link);
        ButterKnife.bind(this);
        AppController.getComponent(this).inject(this);
        processReferralIntent(getIntent(), textViewDeepLink, textViewInviteId);
    }

    @Override
    public void processReferralIntent(Intent intent, TextView textViewDeepLink, TextView textViewInviteId) {
        super.processReferralIntent(intent, textViewDeepLink, textViewInviteId);
    }
}
