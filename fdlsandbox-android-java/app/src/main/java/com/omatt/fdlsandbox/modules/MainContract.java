package com.omatt.fdlsandbox.modules;

import android.content.Intent;

import com.omatt.fdlsandbox.BasePresenter;
import com.omatt.fdlsandbox.BaseView;

/**
 * Created by omarmatthew on 6/27/17.
 * MainActivity View
 */

interface MainContract {
    interface View extends BaseView<Presenter> {
        void updateDynamicLinkLong(String link);

        void updateDynamicLinkShort(String link);
    }
    interface Presenter extends BasePresenter<View> {
        void processDeepLink(Intent intent);

        void buildDynamicLink();
    }
}
