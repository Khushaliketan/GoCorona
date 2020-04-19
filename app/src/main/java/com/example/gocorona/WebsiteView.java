package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebsiteView extends AppCompatActivity {

    String url="";
    private WebView w;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_view);

        Intent i=getIntent();
        url=i.getStringExtra("url");
        p=findViewById(R.id.progress);
        w=findViewById(R.id.web);
        w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        w.setWebViewClient(new WebViewClient()
                           {

                               @Override
                               public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                   super.onPageStarted(view, url, favicon);
                                   p.setVisibility(View.VISIBLE);
                                   setTitle("Loading...");
                               }

                               @Override
                               public void onPageFinished(WebView view, String url) {
                                   super.onPageFinished(view, url);
                                   p.setVisibility(View.GONE);
                                   //setTitle(view.getTitle());
                                   setTitle(R.string.app_name);
                               }

                               @Override
                               public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                                   //super.onReceivedSslError(view, handler, error);
                                   handler.proceed();
                               }


                           }
        );


        w.loadUrl(url);

    }
}
