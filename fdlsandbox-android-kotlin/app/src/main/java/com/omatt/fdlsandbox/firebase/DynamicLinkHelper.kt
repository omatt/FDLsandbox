package com.omatt.fdlsandbox.firebase

import android.content.Context
import android.net.Uri
import com.google.firebase.dynamiclinks.DynamicLink
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.omatt.fdlsandbox.R

/**
 * Created by omarmatthew on 9/16/2017.
 */
class DynamicLinkHelper {
    fun dynamicLinkBuilder(context: Context): DynamicLink.Builder {
        return FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(context.getString(R.string.deep_link)))
                .setDynamicLinkDomain(context.getString(R.string.dynamic_link_domain))
                // Open links with this app on Android
                .setAndroidParameters(DynamicLink.AndroidParameters.Builder().build())
    }

    fun dynamicLinkBuilderTest(context: Context): DynamicLink.Builder {
        return FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(Uri.parse(context.getString(R.string.deep_link)))
                .setDynamicLinkDomain(context.getString(R.string.dynamic_link_domain))
                // Open links with this app on Android
                .setAndroidParameters(DynamicLink.AndroidParameters.Builder(context.packageName).setMinimumVersion(1).build())
                .setSocialMetaTagParameters(DynamicLink.SocialMetaTagParameters.Builder()
                        .setTitle("Title")
                        .setImageUrl(Uri.parse(context.getString(R.string.invitation_custom_image)))
                        .setDescription("Lorem ipsum description about the link.").build())
    }
}