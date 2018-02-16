package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.net.gsonmodel.Category;
import com.github.yglll.funlive.net.gsonmodel.HomeCarousel;
import com.github.yglll.funlive.net.gsonmodel.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.gsonmodel.HomeHotColumn;
import com.github.yglll.funlive.net.gsonmodel.HomeCate;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/19   18:59
 **/
public class RecommendModel implements RecommendPresenterInterfaces.Model{

    @Override
    public Observable<List<String>> getGameString(Map<String, Integer> map) {
        return null;
    }


    @Override
    public Observable<List<HomeCarousel>> getCarousel() {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getCarousel()
                //拦截并处理错误
                .compose(new DefaultTransformer<List<HomeCarousel>>());//转换
    }

    @Override
    public Observable<List<HomeHotColumn>> getHotColumn() {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getHotColumn(ParamsMapUtils.getDefaultParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<HomeHotColumn>>());
    }

    @Override
    public Observable<List<HomeFaceScoreColumn>> getFaceScoreColumn(int offset, int limit) {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getFaceScoreColumn(ParamsMapUtils.getHomeFaceScoreColumn(offset,limit))
                //拦截并处理错误
                .compose(new DefaultTransformer<List<HomeFaceScoreColumn>>());
    }

    @Override
    public Observable<List<HomeCate>> getHotCate() {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getHotCate(ParamsMapUtils.getDefaultParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<HomeCate>>());
    }

    @Override
    public Observable<List<Category>> getNavigation() {
        return new RetrofitClient()
                .builder(Live.class)
                .getCategory()
                //拦截并处理错误
                .compose(new DefaultTransformer<List<Category>>());
    }
}
