package com.huihui.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.huihui.demo.R;

public class WebActivity extends AppCompatActivity {
    private WebView mWebView;
    private String url = "https://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        //LinearLayout rootView = (LinearLayout) findViewById(R.id.activity_web);
         mWebView = ((WebView) findViewById(R.id.view_web));

       // mWebView = new WebView(this);
        //rootView.addView(mWebView);
        WebSettings websetting = mWebView.getSettings();

        websetting.setAppCacheEnabled(false);
        mWebView.loadUrl(url);

        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mWebView != null) {

            ((ViewGroup) mWebView.getParent()).removeView(mWebView);

            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }

    }
}
