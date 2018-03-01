package com.github.yglll.funlive.net.handlingerror;

import com.github.yglll.funlive.net.bean.HttpResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：在新线程中拦截并处理错误
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
