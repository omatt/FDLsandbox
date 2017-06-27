package com.omatt.fdlsandbox;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by omarmatthew on 6/27/17.
 */

public class BasePresenter implements BaseView{
    /**
     * Hide SoftInput Keyboard
     * @param view View
     * @param context Context
     */
    @Override
    public void hideSoftInput(View view, Context context) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
