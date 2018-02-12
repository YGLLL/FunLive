package com.github.yglll.funlive.net.transformer;

import android.util.Log;

import com.github.yglll.funlive.net.Response.HttpResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/03   21:24
 **/
public class DefaultTransformer<T>  implements Observable.Transformer<HttpResponse<T>,T>{
    @Override
    public Observable<T> call(Observable<HttpResponse<T>> httpResponseObservable) {
        return httpResponseObservable. subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .compose(ErrorTransformer.<T>getInstance())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
