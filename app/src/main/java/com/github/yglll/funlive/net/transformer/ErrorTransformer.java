package com.github.yglll.funlive.net.transformer;

import android.util.Log;

import com.github.yglll.funlive.net.Response.HttpResponse;

import rx.Observable;
import rx.functions.Func1;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/03   21:25
 **/
public class ErrorTransformer<T> implements Observable.Transformer<HttpResponse<T>,T> {

    public static <T> ErrorTransformer<T> create() {
        return new ErrorTransformer<>();
    }

    private static ErrorTransformer instance = null;

    private ErrorTransformer(){
    }
    /**
     * 双重校验锁单例(线程安全)
     */
    public static <T>ErrorTransformer<T> getInstance() {
        if (instance == null) {
            synchronized (ErrorTransformer.class) {
                if (instance == null) {
                    instance = new ErrorTransformer();
                }
            }
        }
        return instance;
    }

    @Override
    public Observable<T> call(Observable<HttpResponse<T>> httpResponseObservable) {
        //对服务器端给出Json数据进行校验
        return httpResponseObservable.map(new Func1<HttpResponse<T>, T>() {
            @Override
            public T call(HttpResponse<T> tHttpResponse) {
                if (tHttpResponse.getError()!=0) {
                    //如果服务器端有错误信息返回，那么抛出异常，让下面的方法去捕获异常做统一处理
                    throw  new RuntimeException(String.valueOf(tHttpResponse.getData()));
                }
                ////服务器请求数据成功，返回里面的数据实体
                return tHttpResponse.getData();
            }
//            对请求服务器出现错误信息进行拦截
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                throwable.printStackTrace();
                //return Observable.error(ExceptionHandle.handleException(throwable));
                return null;
            }
        });
    }
}
