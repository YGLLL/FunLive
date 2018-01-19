package com.github.yglll.funlive.net;

import android.text.TextUtils;
import android.util.Log;

import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.net.factory.ConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/21   16:03
 **/
public class RetrofitClient {
    private static String baseUrl;
    private static Retrofit retrofit;

    public RetrofitClient(){
        baseUrl= NetWorkAPI.baseUrl;
    }
    public RetrofitClient(String baseUrl){
        this.baseUrl=baseUrl;
    }

    public RetrofitClient setBaseUrl(String baseUrl){
        this.baseUrl=baseUrl;
        return this;
    }

    public <T>T builder(Class<T> service){
        if(TextUtils.isEmpty(baseUrl)){
            throw new RuntimeException("baseUrl is null!");
        }
        if(service==null){
            throw new RuntimeException("api Service is null!");
        }

        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ConverterFactory.create())//替换成<HttpResponse<>>
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }
}
