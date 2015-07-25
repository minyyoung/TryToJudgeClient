package com.kcg.trytojudge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class facebook extends Activity {

    private WebView facebook_webview;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        class JavaScriptExtention {

            public void LoginFail() {

                //Toast.makeText(getApplicationContext(), "로그인을 취소하였습니다.", Toast.LENGTH_SHORT).show();
                facebook.this.finish();

            }

            public void LoginSuccess(String id, String name) {

                Intent successIntent = new Intent(facebook.this, MainActivity.class);
                successIntent.putExtra("my_id", id);
                successIntent.putExtra("my_name", name);
                facebook.this.finish();
                facebook.this.startActivity(successIntent);

            }
        }

        facebook_webview = (WebView)findViewById(R.id.facebook_webview);

        if (getIntent().getIntExtra("status", 0) == 0) {
            facebook_webview.loadUrl("http://2nsoft.co.kr/stac2015/facebook_connect.html");
        } else {
            facebook_webview.loadUrl("http://2nsoft.co.kr/stac2015/facebook_logout.html");
        }

        facebook_webview.setWebViewClient(new WebViewClient());

        facebook_webview.getSettings().setJavaScriptEnabled(true);
        facebook_webview.addJavascriptInterface(new JavaScriptExtention(), "android");

    }

}