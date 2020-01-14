package com.example.demo;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Uri uri = getIntent().getData();
        String url = "http://stackoverflow.com";
        WebView wv = findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });

        WebSettings set =  wv.getSettings();
        set.setJavaScriptEnabled(true);
        wv.loadUrl(uri.toString());
    }
}

