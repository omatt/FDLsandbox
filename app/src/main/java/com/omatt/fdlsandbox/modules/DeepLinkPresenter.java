package com.omatt.fdlsandbox.modules;

import android.widget.TextView;

/**
 * Created by omarmatthew on 6/27/17.
 * DeepLinkActivity Presenter
 */

public class DeepLinkPresenter implements DeepLinkView{
    private TextView textViewDeepLink;
    private TextView textViewInviteId;

    public DeepLinkPresenter(TextView textViewDeepLink, TextView textViewInviteId) {
        this.textViewDeepLink = textViewDeepLink;
        this.textViewInviteId = textViewInviteId;
    }

    @Override
    public void setDeepLink(String deepLink) {
        textViewDeepLink.setText(deepLink);
    }

    @Override
    public void setInviteId(String inviteId) {
        textViewInviteId.setText(inviteId);
    }


}
