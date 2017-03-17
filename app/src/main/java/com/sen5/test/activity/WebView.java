package com.sen5.test.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebViewClient;

import com.sen5.test.R;
import com.sen5.test.databinding.ActivityWebviewBinding;

/**
 * Created by chenqianghua on 2017/3/15.
 */

public class WebView extends AppCompatActivity {
    private ActivityWebviewBinding databinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        databinding.wbTest.getSettings().setJavaScriptEnabled(true);
        databinding.wbTest.setWebViewClient(new WebViewClient());
        databinding.wbTest.loadUrl("https://yiliapp.otelligent.com/shop?addr=jd");
    }
}
