package com.omatt.fdlsandbox.firebase;

import android.content.Context;
import android.net.Uri;

import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.omatt.fdlsandbox.R;

/**
 * Created by omarmatthew on 6/25/17.
 * Class containing all necessary methods that uses Firebase Dynamic Links
 */

public class DynamicLinkHelper {
    private final String TAG = "DynamicLinkHelper";
    public DynamicLink.Builder dynamicLinkBuilder(Context context){
        return FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(context.getString(R.string.deep_link)))
                .setDynamicLinkDomain(context.getString(R.string.dynamic_link_domain))
                // Open links with this app on Android
                .setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build());
    }
}
