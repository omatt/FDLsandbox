package com.omatt.fdlsandbox;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.omatt.fdlsandbox.modules.main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by omarmatthew on 7/6/17.
 * Espresso UI test sending App Invite
 */
@RunWith(AndroidJUnit4.class)
public class TestAppInviteSend {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void clickSendAppInvite() throws Exception{
        Espresso.onView(ViewMatchers.withId(R.id.btn_app_invite_send)).perform(ViewActions.click());
    }
}
