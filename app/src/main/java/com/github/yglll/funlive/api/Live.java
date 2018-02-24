package com.github.yglll.funlive.api;

import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.bean.TempLiveVideoInfo;
import com.github.yglll.funlive.net.response.HttpResponse;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：使用retrofit2访问API
 * 备注消息：
 * 创建时间：2017/12/21   13:47
 **/
public interface Live {
    @GET(NetWorkAPI.roomList+"{id}")
    Observable<HttpResponse<List<RoomInfo>>> getLiveList(@Path("id") String id, @QueryMap Map<String, Integer> params);

    //首页   推荐轮播图
    @GET(NetWorkAPI.getCarousel)
    Observable<HttpResponse<List<HomeCarousel>>> getCarousel();

    //首页    最热
    @GET(NetWorkAPI.allRoom)
    Observable<HttpResponse<List<RoomInfo>>> getHotColumn(@QueryMap Map<String, Integer> params);

    //首页---颜值
    @GET(NetWorkAPI.faceScoreRoomList)
    Observable<HttpResponse<List<RoomInfo>>> getFaceScoreColumn(@QueryMap Map<String, Integer> params);

    //首页---热门类别
    @GET(NetWorkAPI.getHomeRecommendHotCate)
    Observable<HttpResponse<List<HomeCate>>> getHotCate(@QueryMap Map<String, String> params);

    //获取所有分类
    @GET(NetWorkAPI.allCategory)
    Observable<HttpResponse<List<Category>>> getCategory();

    //所有栏目
    @GET(NetWorkAPI.getCateList)
    Observable<HttpResponse<List<CateList>>> getCateList(@QueryMap Map<String, String> params);

    //获取一个栏目所有类别
    @GET(NetWorkAPI.getCate)
    Observable<HttpResponse<List<CapiCategory>>> getCapiCategory(@QueryMap Map<String, String> params);

    //通过roomId获取视频播放地址
    @GET(NetWorkAPI.getVideoUrl)
    Observable<HttpResponse<TempLiveVideoInfo>> getVideoUrl(@QueryMap Map<String, Integer> params);
}
