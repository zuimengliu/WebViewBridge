package com.syrg.webviewbridge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.syrg.webviewbridgelibrary.WVJBWebView;

import static android.widget.Toast.LENGTH_SHORT;

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        final WVJBWebView webView= (WVJBWebView) findViewById(R.id.webview);
        Button jsRcvResponseTestBtn= (Button) findViewById(R.id.jsRcvResponseTestBtn);
        //注册webview监听
        webView.registerHandler("androidToJs", new WVJBWebView.WVJBHandler() {
            @Override
            public void handler(Object data, WVJBWebView.WVJBResponseCallback callback) {
                Toast.makeText(ExampleActivity.this,data.toString(),LENGTH_SHORT).show();
                Log.d("wvjsblog",data.toString());
                //监听到js调用android 对js进行回调
                callback.onResult("android 回调");
            }
        });

        jsRcvResponseTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接调用调用js
                webView.callHandler("jsRcvResponseTest", "调用js", new WVJBWebView.WVJBResponseCallback() {
                    @Override
                    public void onResult(Object data) {
                        Toast.makeText(ExampleActivity.this,data.toString(),LENGTH_SHORT).show();
                    }
                });
            }
        });

        webView.hasJavascriptMethod("bridgeHandler", new WVJBWebView.WVJBMethodExistCallback() {
            @Override
            public void onResult(boolean exist) {
                if(exist) {
                    Log.d("wvjsblog", "Javascript handler 'bridgeHandler' exist. ");
                }
            }
        });

        webView.loadUrl("file:///android_asset/exampleApp.html");

    }
}
