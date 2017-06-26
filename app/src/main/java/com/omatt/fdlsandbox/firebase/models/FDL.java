package com.omatt.fdlsandbox.firebase.models;

/**
 * Created by omarmatthew on 6/26/17.
 * FDL Object
 * For deep link and invitation ID
 */

public class FDL {
    private String FDLDeepLink;
    private String FDLInviteID;

    public FDL(String fdlDeepLink, String fdlInviteID) {
        FDLDeepLink = fdlDeepLink;
        FDLInviteID = fdlInviteID;
    }

    public String getFDLDeepLink() {
        return FDLDeepLink;
    }

    public void setFDLDeepLink(String FDLDeepLink) {
        this.FDLDeepLink = FDLDeepLink;
    }
}
