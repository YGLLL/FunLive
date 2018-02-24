package com.github.yglll.funlive.net.retrofitfactory;

import java.io.IOException;

import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/24   0:12
 **/
public class RequestBodyConverter<T> implements Converter<T, RequestBody> {
    @Override
    public RequestBody convert(T value) throws IOException {
        return null;
    }
}
