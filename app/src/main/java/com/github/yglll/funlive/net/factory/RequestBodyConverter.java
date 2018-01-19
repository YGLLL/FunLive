package com.github.yglll.funlive.net.factory;

import android.util.Log;

import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/24   0:12
 **/
public class RequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final String TAG = "ConverterFactory";
    @Override
    public RequestBody convert(T value) throws IOException {
        Log.i(TAG,"public RequestBody convert(T value) throws IOException");
        return null;
    }
}
