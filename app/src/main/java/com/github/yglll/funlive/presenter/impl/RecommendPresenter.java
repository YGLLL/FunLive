package com.github.yglll.funlive.presenter.impl;

import android.util.Log;

import com.github.yglll.funlive.model.logic.Category;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.model.logic.HomeFaceScoreColumn;
import com.github.yglll.funlive.model.logic.HomeHotColumn;
import com.github.yglll.funlive.model.logic.HomeCate;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observer;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public class RecommendPresenter extends RecommendPresenterInterfaces.Presenter{
    private static final String TAG = "RecommendPresenter";

    @Override
    public void setCarousel() {
        mModel.getCarousel().subscribe(new Observer<List<HomeCarousel>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"public void onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"public void onError(Throwable e)");
            }

            @Override
            public void onNext(List<HomeCarousel> list) {
                mView.showCarousel(list);
            }
        });
    }

    @Override
    public void setHotColumn() {
        mModel.getHotColumn().subscribe(new Observer<List<HomeHotColumn>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<HomeHotColumn> homeHotColumns) {
                mView.showHotColumn(homeHotColumns);
            }
        });
    }

    @Override
    public void setFaceScoreColumn(int offset,int limit) {
        mModel.getFaceScoreColumn(offset,limit).subscribe(new Observer<List<HomeFaceScoreColumn>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<HomeFaceScoreColumn> list) {
                mView.showFaceScoreColumn(list);
            }
        });
    }

    @Override
    public void setHotCate() {
        mModel.getHotCate().subscribe(new Observer<List<HomeCate>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<HomeCate> homeCates) {
                mView.showHotCate(homeCates);
            }
        });
    }

    @Override
    public void setNavigation() {
        mModel.getNavigation().subscribe(new Observer<List<Category>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Category> list) {
                mView.showNavigation(list);
            }
        });
    }
}
