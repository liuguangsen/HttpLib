package com.liugs.httplib;

public class Volley {
    public static <T, M> void sendJSONRequest(T request, String url, Class<M> response, IDataListener<M> listener) {
        IhttpService ihttpService = new JsonhttpService();
        IHttpListener httpListener = new JsonHttpListener<M>(response, listener);
        HttpTask<T> httpTask = new HttpTask<T>(request, url, ihttpService, httpListener);
        ThreadPoolManager.getInstance().execute(httpTask);
    }
}
