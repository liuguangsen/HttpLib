package com.liugs.httplib;

import android.net.Uri;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonhttpService implements IhttpService{
    String url;
    private byte[] requestInfo;
    private IHttpListener httpListener;
    private HttpURLConnection urlConnection;
    @Override
    public void setUrl(String url) {
        this.url = url;

    }

    @Override
    public void setRequestData(byte[] requestData) {
        this.requestInfo = requestData;
    }

    @Override
    public void execute() {
        //解析网络操作
        URL httpUrl = null;
        try {
            httpUrl = new URL(this.url);
            urlConnection = (HttpURLConnection) httpUrl.openConnection();
            urlConnection.setConnectTimeout(6000);// 链接的超时时间
            urlConnection.setUseCaches(false);
            urlConnection.setInstanceFollowRedirects(true);// 是成员函数，仅仅作用于当前函数
            urlConnection.setReadTimeout(3000);// 响应时间
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type","application/json;charset/utf-8");
            urlConnection.connect();
            // 发送请求字节流
            OutputStream out = urlConnection.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            if (requestInfo != null){
                bos.write(requestInfo);
            }
            //刷一下缓冲区，写入数据
            bos.flush();
            out.close();
            bos.close();
            //写入数据
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream in = urlConnection.getInputStream();
                httpListener.onSuccess(in);
            }
        } catch (IOException e) {
            httpListener.onFailure();
        } finally {
            // 关闭tcp，释放资源
            urlConnection.disconnect();
        }
    }

    @Override
    public void setHttpCallback(IHttpListener listener) {
        this.httpListener = listener;
    }
}
