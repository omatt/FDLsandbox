package com.omatt.fdlsandbox.firebase;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by omarmatthew on 7/5/17.
 * Class containing supplementary methods for Firebase Analytics
 * // TODO integrate Analytics
 */

public class AnalyticsHelper {
    private Bundle bundle;

    private final String TAG_ACTION = "action";
    private final String TAG_ACTION_CLICKED = "clicked";
    private final String TAG_VIEW = "view_id";
    public AnalyticsHelper() {
        bundle = new Bundle();
    }

    public Bundle logEventActionBuilder(String viewId){
        bundle.putString(TAG_ACTION, TAG_ACTION_CLICKED);
        bundle.putString(TAG_VIEW, viewId);
        return bundle;
    }
}
