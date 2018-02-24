package com.github.yglll.funlive.presenter.impl;

import android.util.Log;

import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.handlingerror.ApiException;
import com.github.yglll.funlive.net.handlingerror.subscriber.ErrorSubscriber;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;

import java.util.List;

import rx.Observer;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public class RecommendPresenter extends RecommendPresenterInterfaces.Presenter{

    @Override
    public void setCarousel() {
        mModel.getCarousel().subscribe(new ErrorSubscriber<List<HomeCarousel>>() {

            @Override
            protected void onError(ApiException ex) {

            }

            @Override
            public void onNext(List<HomeCarousel> list) {
                mView.showCarousel(list);
            }
        });
    }

    @Override
    public void setHotColumn() {
        mModel.getHotColumn().subscribe(new ErrorSubscriber<List<RoomInfo>>() {

            @Override
            protected void onError(ApiException ex) {

            }

            @Override
            public void onNext(List<RoomInfo> homeHotColumns) {
                mView.showHotColumn(homeHotColumns);
            }
        });
    }

    @Override
    public void setFaceScoreColumn() {
        mModel.getFaceScoreColumn().subscribe(new ErrorSubscriber<List<RoomInfo>>() {

            @Override
            protected void onError(ApiException ex) {

            }

            @Override
            public void onNext(List<RoomInfo> list) {
                mView.showFaceScoreColumn(list);
            }
        });
    }

    @Override
    public void setHotCate() {
        mModel.getHotCate().subscribe(new ErrorSubscriber<List<HomeCate>>() {

            @Override
            protected void onError(ApiException ex) {

            }

            @Override
            public void onNext(List<HomeCate> homeCates) {
                mView.showHotCate(homeCates);
            }
        });
    }

    @Override
    public void setNavigation() {
        mModel.getNavigation().subscribe(new ErrorSubscriber<List<Category>>() {

            @Override
            protected void onError(ApiException ex) {

            }

            @Override
            public void onNext(List<Category> list) {
                mView.showNavigation(list);
            }
        });
    }
}
