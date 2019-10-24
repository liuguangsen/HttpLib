package com.liugs.httplib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.liugs.httplib.entity.JsonRootBean;
import com.liugs.httplib.entity.Weather;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String URLTEST = "https://api.apiopen.top/musicBroadcastingDetails?channelname=public_tuijian_spring";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void test(View view) {
        Volley.sendJSONRequest(null, URLTEST, JsonRootBean.class, new IDataListener<JsonRootBean>() {
            @Override
            public void onSuccess(JsonRootBean weather) {
                Log.i(TAG,"onSuccess");
            }

            @Override
            public void onFailure() {
                Log.i(TAG,"onFailure");
            }
        });
    }
}
