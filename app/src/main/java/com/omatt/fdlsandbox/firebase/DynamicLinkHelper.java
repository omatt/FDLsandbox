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
    public DynamicLink dynamicLinkTemplate(Context context){
        return FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(context.getString(R.string.deep_link)))
                .setDynamicLinkDomain("abc123.app.goo.gl")
                // Open links with this app on Android
                .setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build())
                .buildDynamicLink();
    }

    public void dynamicLinkShortBuilder(){

    }
}
