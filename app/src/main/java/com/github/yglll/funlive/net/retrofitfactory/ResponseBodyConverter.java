package com.github.yglll.funlive.net.retrofitfactory;

import com.github.yglll.funlive.net.bean.HttpResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：抛出服务器约定异常
 * 备注消息：
 * 创建时间：2017/12/23   23:43
 **/
public class ResponseBodyConverter<T> implements Converter<ResponseBody,T> {

    private final Gson gson;
    private final Type type;

        ResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        String value=responseBody.string();

        HttpResponse httpResponse=new HttpResponse();
        try {
            JSONObject response=new JSONObject(value);
            int error=response.getInt("error");
            if(error!=0) {
                httpResponse.setError(error);
                httpResponse.setData(response.getString("data"));
                //?
                return (T)gson.fromJson(value,httpResponse.getClass());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gson.fromJson(value,type);
    }
}
