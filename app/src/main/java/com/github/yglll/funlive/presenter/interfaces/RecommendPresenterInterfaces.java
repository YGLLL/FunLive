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

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public interface RecommendPresenterInterfaces {
    interface View extends BaseView {
        void showCarousel(List<HomeCarousel> list);
        void showHotColumn(List<RoomInfo> list);
        void showFaceScoreColumn(List<RoomInfo> list);
        void showHotCate(List<HomeCate> list);
        void showNavigation(List<Category> list);
    }

    interface Model extends BaseModel {
        Observable<List<HomeCarousel>> getCarousel();
        Observable<List<RoomInfo>> getHotColumn();
        Observable<List<RoomInfo>> getFaceScoreColumn();
        Observable<List<HomeCate>> getHotCate();
        Observable<List<Category>> getNavigation();
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void setCarousel();
        public abstract void setHotColumn();
        public abstract void setFaceScoreColumn();
        public abstract void setHotCate();
        public abstract void setNavigation();
    }
}
