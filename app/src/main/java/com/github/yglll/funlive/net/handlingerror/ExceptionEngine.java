package com.github.yglll.funlive.net.handlingerror;


import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.orhanobut.logger.Logger;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.UnknownHostException;

import retrofit2.HttpException;


public class ExceptionEngine {
    //对应HTTP的状态码
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int BAD_GATEWAY = 502;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e){
        ApiException ex;
        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ERROR.HTTP_ERROR);
            switch(httpException.code()){
                case UNAUTHORIZED:
                    ex.code=UNAUTHORIZED;
                    ex.message="未授权";
                    break;
                case FORBIDDEN:
                    ex.code=FORBIDDEN;
                    ex.message="禁止访问";
                    break;
                case NOT_FOUND:
                    ex.code=NOT_FOUND;
                    ex.message="服务器找不到给定的资源";
                    break;
                case REQUEST_TIMEOUT:
                    ex.code=REQUEST_TIMEOUT;
                    ex.message="请求超时";
                    break;
                case GATEWAY_TIMEOUT:
                    ex.code=GATEWAY_TIMEOUT;
                    ex.message="网关超时";
                    break;
                case INTERNAL_SERVER_ERROR:
                    ex.code=INTERNAL_SERVER_ERROR;
                    ex.message="服务器内部错误";
                    break;
                case BAD_GATEWAY:
                    ex.code=BAD_GATEWAY;
                    ex.message="错误网关";
                    break;
                case SERVICE_UNAVAILABLE:
                    ex.code=SERVICE_UNAVAILABLE;
                    ex.message="无法获得服务";
                    break;
                default:
                    ex.message = "网络错误";  //均视为网络错误
                    break;
            }
            return ex;
        } else if (e instanceof ServerException){    //服务器返回的错误
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException, resultException.code);
            ex.message = resultException.message;
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException){
            ex = new ApiException(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";            //均视为解析错误
            return ex;
        }else if(e instanceof ConnectException){
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.message = "连接失败";  //均视为网络错误
            return ex;
        }else if(e instanceof UnknownHostException){
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.message = "网络连接不可用";  //均视为网络错误
            return ex;
        }else if(e instanceof RuntimeException){//服务端返回的错误
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.message = e.getMessage();
            return ex;
        }else {
            Logger.i("ERROR.UNKNOWN:"+e.toString());
            ex = new ApiException(e, ERROR.UNKNOWN);
            ex.message = "未知错误";          //未知错误
            return ex;
        }
    }
}
