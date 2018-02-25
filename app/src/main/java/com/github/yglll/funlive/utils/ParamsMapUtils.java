package com.github.yglll.funlive.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/21   13:27
 **/
public class ParamsMapUtils extends BaseParamsMapUtil {

    private static Map<String, String> mapparam;

    //*************************baseApi************************************

    //默认baseApi参数
    public static Map<String, Integer> getBaseApiDefaultParams() {
        return getBaseApiDefaultParams(0,12);
    }
    public static Map<String, Integer> getBaseApiDefaultParams(int offset,int limit) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("offset", offset);
        map.put("limit", limit);
        return map;
    }
    //首页热门类参数
    public static Map<String, Integer> getRecommendHotParams() {
        return getBaseApiDefaultParams(0,4);
    }
    //首页其他类参数
    public static Map<String, Integer> getRecommendOtherCateParams() {
        return getBaseApiDefaultParams(0,4);
    }
    //**************************baseApi_capi***************************************

    //默认参数
    public static Map<String, String> getDefaultParams() {
        return getParamsMap();
    }

    //首页 列表详情
    public static Map<String, String> getHomeCate(String identification) {
        mapparam = getDefaultParams();
        mapparam.put("identification", identification);
        return mapparam;
    }

    public static Map<String, String> getHomeCarousel() {
        mapparam = getDefaultParams();
        mapparam.put("version", "2.421");
        return mapparam;
    }

    //其他栏目二级分类
    public static Map<String, String> getLiveOtherTwoColumn(String ColumnName) {
        mapparam = getDefaultParams();
        mapparam.put("shortName",ColumnName);
        return mapparam;
    }
}
