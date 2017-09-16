package com.omatt.fdlsandbox.firebase.models;

/**
 * Created by omarmatthew on 6/26/17.
 * FDL Object
 * For deep link and invitation ID
 */

public class FDL {
    private String fdlDeepLink;
    private String fdlInviteID;

    /**
     * Initialized null val
     */
    public FDL() {
        this.fdlDeepLink = null;
        this.fdlInviteID = null;
    }

    public FDL(String fdlDeepLink, String fdlInviteID) {
        this.fdlDeepLink = fdlDeepLink;
        this.fdlInviteID = fdlInviteID;
    }

    public String getFDLDeepLink() {
        return fdlDeepLink;
    }

    public void setFDLDeepLink(String FDLDeepLink) {
        this.fdlDeepLink = FDLDeepLink;
    }

    public String getFdlInviteID() {
        return fdlInviteID;
    }

    public void setFdlInviteID(String fdlInviteID) {
        this.fdlInviteID = fdlInviteID;
    }
}
