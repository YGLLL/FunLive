package com.github.yglll.funlive.net.handlingerror.subscriber;

import com.github.yglll.funlive.net.handlingerror.ApiException;

import rx.Observer;


public abstract class ErrorSubscriber<T> implements Observer<T> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof ApiException){
            onError((ApiException)e);
        }else{
            onError(new ApiException(e,123));
        }
    }

    /**
     * 错误回调
     */
    protected abstract void onError(ApiException ex);
}
