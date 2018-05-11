package com.github.yglll.funlive.net.bean;


public class HttpResponse<T> {
    private int error;
    private T data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}
