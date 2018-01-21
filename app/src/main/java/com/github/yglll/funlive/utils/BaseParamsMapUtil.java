package com.github.yglll.funlive.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/21   13:26
 **/
public class BaseParamsMapUtil {
    //公共的参数集合
    public static Map<String, String> getParamsMap() {
        Map<String, String> paramsmap = new LinkedHashMap<>();
        paramsmap.put("client_sys", "android");
        paramsmap.put("aid", "android1");
        paramsmap.put("time",System.currentTimeMillis()+"");
        return paramsmap;
    }
}
