package com.omatt.fdlsandbox.modules;

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

public class WebViewActivity extends AppCompatActivity {
    private final String TAG = "WebViewActivity";
    //    private final String dynamicLink = "https://kuta9.app.goo.gl/YJ5F";
    private final String dynamicLink = "https://s3qmk.app.goo.gl/z1Na";
    @BindView(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_web_view);
        ButterKnife.bind(this);
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