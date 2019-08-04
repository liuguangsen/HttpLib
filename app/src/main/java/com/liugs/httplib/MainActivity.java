package com.liugs.httplib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.liugs.httplib.entity.Weather;

public class MainActivity extends AppCompatActivity {

    private static final String URLTEST = "https://v/juhe.cn/weather/index?cityname=长沙&key=fd0f609b22905a0a56a48d7cf9a558b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void test(View view) {
        Volley.sendJSONRequest(null, URLTEST, Weather.class, new IDataListener<Weather>() {
            @Override
            public void onSuccess(Weather weather) {

            }

            @Override
            public void onFailure() {

            }
        });
    }
}
