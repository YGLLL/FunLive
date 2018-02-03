package com.github.yglll.funlive.model;

import android.content.Context;
import android.util.Log;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.model.logic.Category;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.model.logic.HomeFaceScoreColumn;
import com.github.yglll.funlive.model.logic.HomeHotColumn;
import com.github.yglll.funlive.model.logic.HomeRecommendHotCate;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.transformer.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    public Observable<String> getString(String string , Map<String,Integer> map){
        Logger.i("Observable<String> getString");
        return new RetrofitClient()
                .builder(Live.class)
                .getLiveList(string,map)
                .subscribeOn(Schedulers.io())//在io线程发出事件
                .observeOn(AndroidSchedulers.mainThread());//在ui线程订阅事件
    }

    @Override
    public Observable<List<String>> getGameString(Map<String, Integer> map) {
        return null;
    }


    @Override
    public Observable<List<HomeCarousel>> getCarousel() {
        Log.i("xiancheng","Model id:"+android.os.Process.myTid());
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getCarousel()
                .compose(new DefaultTransformer<List<HomeCarousel>>());//转换
    }

    @Override
    public Observable<List<HomeHotColumn>> getHotColumn() {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getHotColumn(ParamsMapUtils.getDefaultParams())
                .compose(new DefaultTransformer<List<HomeHotColumn>>());
    }

    @Override
    public Observable<List<HomeFaceScoreColumn>> getFaceScoreColumn(int offset, int limit) {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getFaceScoreColumn(ParamsMapUtils.getHomeFaceScoreColumn(offset,limit))
                .compose(new DefaultTransformer<List<HomeFaceScoreColumn>>());
    }

    @Override
    public Observable<List<HomeRecommendHotCate>> getHotCate() {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getHotCate(ParamsMapUtils.getDefaultParams())
                .compose(new DefaultTransformer<List<HomeRecommendHotCate>>());
    }

    @Override
    public Observable<List<Category>> getNavigation() {
        return new RetrofitClient()
                .builder(Live.class)
                .getCategory()
                .compose(new DefaultTransformer<List<Category>>());
    }
}
