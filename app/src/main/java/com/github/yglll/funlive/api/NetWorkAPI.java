package com.github.yglll.funlive.api;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/13   7:15
 **/
public class NetWorkAPI {
    //base地址
    public static final String baseUrl="http://open.douyucdn.cn/";

    //获取直播房间列表
    //http://open.douyucdn.cn/api/RoomApi/live/{分类 ID 戒者分类别名}
    //http://open.douyucdn.cn/api/RoomApi/live获取所有直播列表
    public static final String roomList="api/RoomApi/live/";

    //获取直播房间详情信息/api/RoomApi/room/{房间 Id 或者房间别名}
    public static final String details="api/RoomApi/room/";

    //获取所有分类 /api/RoomApi/game
    public static final String allCategory="api/RoomApi/game";

    //****************************************************************
    //旧base地址
    public static final String baseUrl_capi = "http://capi.douyucdn.cn/";
    //*********************首页****************************
    //栏目>类别>房间
    //轮播图
    public static final String getCarousel = "api/v1/slide/6";
    //最热房间列表
    public static final String getHomeHotColumn = "api/v1/getbigDataRoom";
    //颜值房间列表
    public static final String getHomeFaceScoreColumn = "api/v1/getVerticalRoom";
    //热门类别列表
    public static final String getHomeRecommendHotCate = "api/v1/getHotCate";
    //栏目列表
    public static final String getCateList = "/api/v1/getColumnList";
    //获取栏目中的类别列表
    public static final String getCate = "/api/v1/getColumnDetail";
}