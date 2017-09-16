package com.omatt.fdlsandbox.firebase

import android.os.Bundle

/**
 * Created by omarmatthew on 9/16/2017.
 */
class AnalyticsHelper{
    private val TAG_ACTION = "action"
    private val TAG_ACTION_CLICKED = "clicked"
    private val TAG_VIEW = "view_id"
    fun logEventActionBuilder(viewId : String): Bundle{
        val bundle = Bundle()
        bundle.putString(TAG_ACTION, TAG_ACTION_CLICKED)
        bundle.putString(TAG_VIEW, viewId)
        return bundle
    }
}