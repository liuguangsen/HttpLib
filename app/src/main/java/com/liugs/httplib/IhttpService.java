package com.liugs.httplib;

public interface IhttpService {
    void setUrl(String url);

    void setRequestData(byte[] requestData);

    void execute();

    void setHttpCallback(IHttpListener listener);
}
