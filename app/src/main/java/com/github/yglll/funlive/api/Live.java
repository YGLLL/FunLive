package com.github.yglll.funlive.api;

import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
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

import static com.github.yglll.funlive.api.NetWorkAPI.allCategory;
import static com.github.yglll.funlive.api.NetWorkAPI.getCarousel;
import static com.github.yglll.funlive.api.NetWorkAPI.getCate;
import static com.github.yglll.funlive.api.NetWorkAPI.getCateList;
import static com.github.yglll.funlive.api.NetWorkAPI.getHomeFaceScoreColumn;
import static com.github.yglll.funlive.api.NetWorkAPI.getHomeHotColumn;
import static com.github.yglll.funlive.api.NetWorkAPI.getHomeRecommendHotCate;
import static com.github.yglll.funlive.api.NetWorkAPI.getVideoUrl;
import static com.github.yglll.funlive.api.NetWorkAPI.roomList;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：使用retrofit2访问API
 * 备注消息：
 * 创建时间：2017/12/21   13:47
 **/
public interface Live {
    @GET(roomList+"{id}")
    Observable<HttpResponse<List<RoomInfo>>> getLiveList(@Path("id") String id, @QueryMap Map<String, Integer> params);

    //首页   推荐轮播图
    @GET(getCarousel)
    Observable<HttpResponse<List<HomeCarousel>>> getCarousel();

    //首页    最热
    @GET(getHomeHotColumn)
    Observable<HttpResponse<List<HomeHotColumn>>> getHotColumn(@QueryMap Map<String, String> params);

    //首页---颜值
    @GET(getHomeFaceScoreColumn)
    Observable<HttpResponse<List<HomeFaceScoreColumn>>> getFaceScoreColumn(@QueryMap Map<String, String> params);

    //首页---热门类别
    @GET(getHomeRecommendHotCate)
    Observable<HttpResponse<List<HomeCate>>> getHotCate(@QueryMap Map<String, String> params);

    //获取所有分类
    @GET(allCategory)
    Observable<HttpResponse<List<Category>>> getCategory();

    //所有栏目
    @GET(getCateList)
    Observable<HttpResponse<List<CateList>>> getCateList(@QueryMap Map<String, String> params);

    //获取一个栏目所有类别
    @GET(getCate)
    Observable<HttpResponse<List<CapiCategory>>> getCapiCategory(@QueryMap Map<String, String> params);

    //通过roomId获取视频播放地址
    @GET(getVideoUrl)
    Observable<HttpResponse<TempLiveVideoInfo>> getVideoUrl(@QueryMap Map<String, Integer> params);
}
