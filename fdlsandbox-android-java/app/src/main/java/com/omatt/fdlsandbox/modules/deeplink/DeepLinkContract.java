package com.omatt.fdlsandbox.modules.deeplink;

import android.content.Intent;

import com.omatt.fdlsandbox.BasePresenter;
import com.omatt.fdlsandbox.BaseView;

/**
 * Created by omarmatthew on 9/11/17.
 */

public interface DeepLinkContract {
    interface View extends BaseView<Presenter> {
        void updateDeepLink(String deepLink);

        void updateInviteId(String inviteId);

        void updateReferrerId(String referrerId);
    }
    interface Presenter extends BasePresenter<View> {
        void processDeepLink(Intent intent);
    }
}
