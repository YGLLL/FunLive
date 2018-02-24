package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;

import rx.Observable;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/19   18:59
 **/
public class RecommendModel implements RecommendPresenterInterfaces.Model{

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
    public Observable<List<RoomInfo>> getHotColumn() {
        return new RetrofitClient()
                .builder(Live.class)
                .getHotColumn(ParamsMapUtils.getRecommendHotParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<RoomInfo>>());
    }

    @Override
    public Observable<List<RoomInfo>> getFaceScoreColumn() {
        return new RetrofitClient()
                .builder(Live.class)
                .getFaceScoreColumn(ParamsMapUtils.getRecommendOtherCateParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<RoomInfo>>());
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
