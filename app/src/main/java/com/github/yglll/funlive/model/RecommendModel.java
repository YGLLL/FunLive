package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.FunLiveAPI;
import com.github.yglll.funlive.api.APILocation;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;
import java.util.Map;

import rx.Observable;


public class RecommendModel implements RecommendPresenterInterfaces.Model{

    @Override
    public Observable<List<HomeCarousel>> getCarousel() {
        return new RetrofitClient()
                .setBaseUrl(APILocation.baseUrl_capi)
                .builder(FunLiveAPI.class)
                .getCarousel()
                //拦截并处理错误
                .compose(new DefaultTransformer<List<HomeCarousel>>());//转换
    }

    @Override
    public Observable<List<HomeHotColumn>> getHotColumn() {
        return new RetrofitClient()
                .setBaseUrl(APILocation.baseUrl_capi)
                .builder(FunLiveAPI.class)
                .getHotColumn()
                //拦截并处理错误
                .compose(new DefaultTransformer<List<HomeHotColumn>>());
    }

    @Override
    public Observable<List<RoomInfo>> getFaceScoreColumn() {
        return new RetrofitClient()
                .builder(FunLiveAPI.class)
                .getFaceScoreColumn(ParamsMapUtils.getRecommendOtherCateParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<RoomInfo>>());
    }

    @Override
    public Observable<List<Category>> getAllCates(){
        return new RetrofitClient()
                .builder(FunLiveAPI.class)
                .getAllCategory()
                //拦截并处理错误
                .compose(new DefaultTransformer<List<Category>>());
    }

    @Override
    public Observable<List<RoomInfo>> getRoomList(String cateId, Map<String, Integer> map) {
        return new RetrofitClient()
                .builder(FunLiveAPI.class)
                .getRoomList(cateId,map)
                .compose(new DefaultTransformer<List<RoomInfo>>());
    }
}
