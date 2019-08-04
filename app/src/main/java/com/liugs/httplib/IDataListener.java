package com.liugs.httplib;

public interface IDataListener<M> {
    void onSuccess(M m);
    void onFailure();
}
