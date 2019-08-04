package com.liugs.httplib;

import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;

public class HttpTask<T> implements Runnable{

    private IhttpService ihttpService;
    private IHttpListener httpListener;

    public <T>HttpTask(T requestInfo,String url ,IhttpService ihttpService, IHttpListener httpListener) {
        this.ihttpService = ihttpService;
        this.httpListener = httpListener;
        ihttpService.setUrl(url);
        ihttpService.setHttpCallback(httpListener);
        if (requestInfo != null){
            String requestContent = JSON.toJSONString(requestInfo);
            ihttpService.setRequestData(requestContent.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public void run() {
        ihttpService.execute();
    }
}
