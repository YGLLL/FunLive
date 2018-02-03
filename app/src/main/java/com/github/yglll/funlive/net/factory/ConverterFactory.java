package com.github.yglll.funlive.net.factory;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/23   23:38
 **/
public class ConverterFactory extends Converter.Factory {
    private final Gson gson;

    public  static ConverterFactory create() {
        return create(new Gson());
    }
    public static ConverterFactory create(Gson gson) {
        return new ConverterFactory(gson);
    }
    private ConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new RequestBodyConverter<>();
    }
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type.toString().contains("String")){
            return new Converter<ResponseBody, String>() {
                @Override
                public String convert(ResponseBody value) throws IOException {
                    return value.string();
                }
            };
        }
        return new ResponseBodyConverter<>(gson,type);
    }
}
