package com.github.yglll.funlive.presenter.impl;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.handlingerror.ApiException;
import com.github.yglll.funlive.net.handlingerror.subscriber.ErrorSubscriber;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public class RecommendPresenter extends RecommendPresenterInterfaces.Presenter{

    private List<Category> allCates;
    private List<List<RoomInfo>> data;
    private int loadLimit=6;
    private int count=0;

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
    public void setNavigation() {
        mModel.getAllCates().subscribe(new ErrorSubscriber<List<Category>>() {

            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<Category> list) {
                allCates=new ArrayList<>();
                allCates.addAll(list);

                List<Category> categories=new ArrayList<>();
                categories.addAll(list.subList(0,7));
                mView.showNavigation(categories);

                setHotCates();
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

    private void setHotCates() {
        if(count==0){
            data=new ArrayList<>();
            getCategorysRooms(allCates.subList(0,loadLimit));
        }
    }

    @Override
    public void setMoreHotCates() {
        if(count==0){
            data=new ArrayList<>();
            getCategorysRooms(allCates.subList(0,loadLimit));
        }
    }

    //迭代,获得每一个Category的4间房间
    private void getCategorysRooms(final List<Category> categories){
        if(count<categories.size()){
            //不再加载颜值类别，上面已加载
            if(categories.get(count).getCate_id()==201){
                count++;
                getCategorysRooms(categories);
            }else {
                mModel.getRoomList(String.valueOf(categories.get(count).getCate_id()),
                        ParamsMapUtils.getRecommendOtherCateParams()).subscribe(new ErrorSubscriber<List<RoomInfo>>() {
                    @Override
                    protected void onError(ApiException ex) {
                        mView.showErrorWithStatus(ex.message);
                    }

                    @Override
                    public void onNext(List<RoomInfo> roomInfos) {
                        count++;
                        data.add(roomInfos);
                        getCategorysRooms(categories);
                    }
                });
            }
        }else {
            //迭代完毕
            count=0;
            List<Category> list1=new ArrayList<>();
            list1.addAll(categories);
            categories.clear();
            List<List<RoomInfo>> list2=new ArrayList<>();
            list2.addAll(data);
            data.clear();

            mView.showHotCates(list1,list2);
        }
    }
}
