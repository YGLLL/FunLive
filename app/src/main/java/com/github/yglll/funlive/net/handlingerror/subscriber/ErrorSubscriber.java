package com.github.yglll.funlive.net.handlingerror.subscriber;

import com.github.yglll.funlive.net.handlingerror.ApiException;

import rx.Observer;


/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/16   23:32
 **/
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
