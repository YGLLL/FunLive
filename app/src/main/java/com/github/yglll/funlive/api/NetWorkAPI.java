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
    //    首页轮播
    public static final String getCarousel = "api/v1/slide/6";
    //首页    最热
    public static final String getHomeHotColumn = "api/v1/getbigDataRoom";
    //    首页---颜值栏目
    public static final String getHomeFaceScoreColumn = "api/v1/getVerticalRoom";
    //首页---其他热门 种类
    public static final String getHomeRecommendHotCate = "api/v1/getHotCate";
}