package com.example.a360rfandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Objects;

public class IndividualForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_form);
        int positionIn=getIntent().getIntExtra("positionIn",8);
        //Toast.makeText(this,String.valueOf(positionIn),Toast.LENGTH_SHORT).show();

        WebView mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
        String url="";
       switch(positionIn)
        {
            case 0:
                url="https://docs.google.com/forms/d/e/1FAIpQLSfq57ozq86CDexrf_Xm24GICPxhc3rCyCqAwy_HzwcevVZDtg/viewform?usp=sf_link";
                break;
            case 1:
                url="https://docs.google.com/forms/d/e/1FAIpQLScYErJyUD2S_XH-d5xMMvEcetzda06iVGobKV5JSRKxQ6Zb5Q/viewform?usp=sf_link";
                break;
            case 2:
                url="https://docs.google.com/forms/d/e/1FAIpQLSd9GQSbmCAltTEVy6mCUJB2dcEgfE859YcXYQUaFl1D1Ei6AQ/viewform?usp=sf_link";
                break;
            case 3:
                url="https://docs.google.com/forms/d/e/1FAIpQLSdtdLeSGhDPgL3SLH6UPl8BG2FcnI2AKWw4LEQ6pAZBt08Fow/viewform?usp=sf_link";
                break;
            case 4:
                url="https://docs.google.com/forms/d/e/1FAIpQLSfe5Yq8ptXqyIGOTpZw3HzqCY3ttlVKE_X5XuBb_0bi14L0VA/viewform?usp=sf_link";
                break;
            case 5:
                url="https://docs.google.com/forms/d/e/1FAIpQLScq4hpDhVpJNdoqWPalD_kqJNd7X8_2v4bBzijlJXOImwapmw/viewform?usp=sf_link";
                break;
            case 6:
                url="https://docs.google.com/forms/d/e/1FAIpQLSf5ma3Sey9J3IX3of6IeVjf4GEGM66ygt6SLrLm3PHPIGKv_A/viewform?usp=sf_link";
                break;
            case 7:
                url="https://docs.google.com/forms/d/e/1FAIpQLSeF2hm212GxBB2HUxURi3X4D2Zgvh8hzixEo0U75U9EVQ1pSw/viewform?usp=sf_link";
                break;
            case 8:
                url="https://docs.google.com/forms/d/e/1FAIpQLSdP1YOP44e4XIaSCNYsLwDG6ti7ZF4uhr8_KZ0HHt2rUXSOsg/viewform?usp=sf_link";
                break;
        }
        mWebview .loadUrl(url);

        setContentView(mWebview );


    }
}