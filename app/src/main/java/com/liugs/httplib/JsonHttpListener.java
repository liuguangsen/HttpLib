package com.liugs.httplib;

import android.os.Handler;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonHttpListener<M> implements IHttpListener{

    Class<M> responseClass;
    private IDataListener<M> listener;
    private Handler handler = new Handler();

    public JsonHttpListener(Class<M> responseClass, IDataListener<M> listener) {
        this.responseClass = responseClass;
        this.listener = listener;
    }

    @Override
    public void onSuccess(InputStream inputStream) {
        //获取响应结果
        String content = getContent(inputStream);
        final M response = JSON.parseObject(content,responseClass);
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onSuccess(response);
            }
        });
    }

    private String getContent(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            try {
                line = reader.readLine();
                if (line == null){
                    break;
                }
                sb.append(line);
            } catch (IOException e) {
                break;
            }
        }
        return sb.toString();
    }

    @Override
    public void onFailure() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFailure();
            }
        });
    }
}
