package com.example.bai13_buoi6_nguyenthiyenkhoa_b1709343;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {
    WebView brower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        brower = (WebView) findViewById(R.id.webview);
        brower.setWebViewClient(new WebViewClient());

        brower.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        brower.loadUrl(url);
    }
}
