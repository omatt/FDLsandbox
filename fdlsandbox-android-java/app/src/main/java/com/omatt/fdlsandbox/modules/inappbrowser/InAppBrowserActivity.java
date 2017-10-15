package com.omatt.fdlsandbox.modules.inappbrowser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.omatt.fdlsandbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * Created by omarmatthew on 10/12/17.
 * Simulates an in-app browser
 */

public class InAppBrowserActivity extends AppCompatActivity {
    private final String TAG = "WebViewActivity";
    private String dynamicLink;
    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_in_app_browser);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) dynamicLink = bundle.getString("KEY_FDL");
        initWebView(false, dynamicLink);
    }

    // If true, the dynamic link will be forced to be load in the WebView
    @OnCheckedChanged(R.id.switch_override_webview)
    void onSwitchChanged(boolean checked) {
        Log.i(TAG, "switch " + checked);
        initWebView(checked, dynamicLink);
    }

    void initWebView(boolean overrideWebView, String dynamicLink) {
        if (overrideWebView) webView.setWebViewClient(new CustomWebViewClient());
        else webView.setWebViewClient(null);
        webView.loadData(
                "<html>\n" +
                        "<body>\n" +
                        "Click <a href=\"" + dynamicLink + "\">here</a> to go to your FDL.\n" +
                        "</body>\n" +
                        "</html>",
                "text/html; charset=utf-8", "UTF-8");
    }
}

// Override web view client implementation
class CustomWebViewClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        // Load the url to the WebView
        view.loadUrl(url);
        // return true if this method handled the link event
        // or false otherwise
        return true;
    }
}