package com.github.yglll.funlive.net;

import android.text.TextUtils;

import com.github.yglll.funlive.api.APILocation;
import com.github.yglll.funlive.net.retrofitfactory.ConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


public class RetrofitClient {
    private static String baseUrl;
    private static Retrofit retrofit;

    public RetrofitClient(){
        baseUrl= APILocation.baseUrl;
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
                //抛出服务器约定异常
                .addConverterFactory(ConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }
}
