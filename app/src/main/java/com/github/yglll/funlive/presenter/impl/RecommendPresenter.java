package com.github.yglll.funlive.presenter.impl;

import android.util.Log;
import android.widget.Toast;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.handlingerror.ApiException;
import com.github.yglll.funlive.net.handlingerror.ExceptionEngine;
import com.github.yglll.funlive.net.handlingerror.subscriber.ErrorSubscriber;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import rx.Observer;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public class RecommendPresenter extends RecommendPresenterInterfaces.Presenter{

    private List<Category> dataHead;
    private List<List<RoomInfo>> data;

    @Override
    public void setCarousel() {
        mModel.getCarousel().subscribe(new ErrorSubscriber<List<HomeCarousel>>() {

            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
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
                mView.showErrorWithStatus(ex.message);
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
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<RoomInfo> list) {
                mView.showFaceScoreColumn(list);
            }
        });
    }

    @Override
    public void setHotCates() {
        mModel.getCates(ParamsMapUtils.getRecommendCateParams()).subscribe(new ErrorSubscriber<List<Category>>() {
            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<Category> categories) {
                data=new ArrayList<>();
                dataHead=new ArrayList<>();
                dataHead.addAll(categories);
                getCategorysRooms(categories);
            }
        });
    }

    //迭代
    private void getCategorysRooms(final List<Category> categories){
        if(categories.size()>0){
            if(categories.get(0).getCate_id()==201){
                categories.remove(0);
                getCategorysRooms(categories);
            }
            mModel.getRoomList(String.valueOf(categories.get(0).getCate_id()),
                    ParamsMapUtils.getRecommendOtherCateParams()).subscribe(new ErrorSubscriber<List<RoomInfo>>() {
                @Override
                protected void onError(ApiException ex) {
                    mView.showErrorWithStatus(ex.message);
                }

                @Override
                public void onNext(List<RoomInfo> roomInfos) {
                    data.add(roomInfos);
                    categories.remove(0);
                    getCategorysRooms(categories);
                }
            });
        }else {
            mView.showHotCates(dataHead,data);
        }
    }

    @Override
    public void setNavigation() {
        mModel.getNavigation().subscribe(new ErrorSubscriber<List<Category>>() {

            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<Category> list) {
                mView.showNavigation(list);
            }
        });
    }
}
