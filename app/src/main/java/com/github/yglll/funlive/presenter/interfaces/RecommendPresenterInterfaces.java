package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.mvpbase.BaseModel;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.net.bean.RoomInfo;

import java.util.List;
import java.util.Map;

import rx.Observable;


public interface RecommendPresenterInterfaces {
    interface View extends BaseView {
        void showCarousel(List<HomeCarousel> list);
        void showNavigation(List<Category> list);
        void showHotColumn(List<HomeHotColumn> list);
        void showFaceScoreColumn(List<RoomInfo> list);
        void showHotCates(List<Category> categories,List<List<RoomInfo>> roomList);
    }

    interface Model extends BaseModel {
        Observable<List<HomeCarousel>> getCarousel();
        Observable<List<Category>> getAllCates();
        Observable<List<HomeHotColumn>> getHotColumn();
        Observable<List<RoomInfo>> getFaceScoreColumn();
        Observable<List<RoomInfo>> getRoomList(String cateId,Map<String,Integer> map);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void setCarousel();
        public abstract void setNavigation();
        public abstract void setHotColumn();
        public abstract void setFaceScoreColumn();
        public abstract void setMoreHotCates();
    }
}
