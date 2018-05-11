package com.github.yglll.funlive.api;

import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.bean.TempLiveVideoInfo;
import com.github.yglll.funlive.net.bean.HttpResponse;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface FunLiveAPI {
    //*******************baseApi**************************************************

    @GET(APILocation.roomList+"{id}")
    Observable<HttpResponse<List<RoomInfo>>> getRoomList(@Path("id") String id, @QueryMap Map<String, Integer> params);

    //首页颜值
    @GET(APILocation.faceScoreRoomList)
    Observable<HttpResponse<List<RoomInfo>>> getFaceScoreColumn(@QueryMap Map<String, Integer> params);

    //获取所有分类
    @GET(APILocation.allCategory)
    Observable<HttpResponse<List<Category>>> getAllCategory();


    //*************************baseApi_capi*****************************************


    //首页   推荐轮播图
    @GET(APILocation.getCarousel)
    Observable<HttpResponse<List<HomeCarousel>>> getCarousel();

    //首页最热
    @GET(APILocation.getHomeHotColumn)
    Observable<HttpResponse<List<HomeHotColumn>>> getHotColumn();

    //首页---热门类别
    @GET(APILocation.getRecommendHotCate)
    Observable<HttpResponse<List<HomeCate>>> getHotCate(@QueryMap Map<String, Integer> params);

    //所有栏目
    @GET(APILocation.getCateList)
    Observable<HttpResponse<List<CateList>>> getCateList(@QueryMap Map<String, String> params);

    //获取一个栏目所有类别
    @GET(APILocation.getCate)
    Observable<HttpResponse<List<CapiCategory>>> getCapiCategory(@QueryMap Map<String, String> params);

    //通过roomId获取视频播放地址
    @GET(APILocation.getVideoUrl)
    Observable<HttpResponse<TempLiveVideoInfo>> getVideoUrl(@QueryMap Map<String, Integer> params);
}
