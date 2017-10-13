package com.omatt.fdlsandbox.modules.deeplink;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.omatt.fdlsandbox.R;
import com.omatt.fdlsandbox.AppController;
import com.omatt.fdlsandbox.modules.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by omarmatthew on 6/24/17.
 * DeepLinkActivity handles FDL deep links
 */

public class DeepLinkActivity extends AppCompatActivity implements DeepLinkContract.View{
    private final String TAG = "DeepLinkActivity";
    @BindView(R.id.textView_deep_link)
    TextView textViewDeepLink;
    @BindView(R.id.textView_invite_id)
    TextView textViewInviteId;
    @BindView(R.id.textView_referrer_id)
    TextView textViewReferrerId;

    @OnClick(R.id.btn_app_invite_ok)
    void onClickedOk() {
        finish();
    }

    @Inject
    DeepLinkPresenter mDeepLinkPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_deep_link);
        ButterKnife.bind(this);
        AppController.getComponent(this).inject(this);

        mDeepLinkPresenter.processDeepLink(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDeepLinkPresenter.takeView(this);
    }

    @Override
    protected void onDestroy() {
        mDeepLinkPresenter.dropView();
        super.onDestroy();
    }

    @Override
    public MainActivity getMainActivity() {
        return null;
    }

    @Override
    public void updateDeepLink(String deepLink) {
        textViewDeepLink.setText(deepLink);
    }

    @Override
    public void updateInviteId(String inviteId) {
        textViewInviteId.setText(inviteId);
    }

    @Override
    public void updateReferrerId(String referrerId) {
        textViewReferrerId.setText(referrerId);
    }
}
