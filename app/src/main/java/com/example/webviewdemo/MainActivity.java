package com.example.webviewdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView=findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new FullScreenClient(MainActivity.this){
            @Override
            public void onHideCustomView()
            {
                hideFullScreen(webView);
            }
            @Override
            public Bitmap getDefaultVideoPoster()
            {
                return videoBitmap();
            }
            @Override
            public void onShowCustomView(View view,CustomViewCallback callback)
            {
                showFullScreen(view,callback);
            }

        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.youtube.com");




    }
}