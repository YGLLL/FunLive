package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.net.bean.TempLiveVideoInfo;
import com.github.yglll.funlive.mvpbase.BaseModel;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;

import rx.Observable;


public interface VideoPlayerInterfaces {
    interface View extends BaseView {
        void acquisitionVideoUrl(String url);
    }

    interface Model extends BaseModel {
        Observable<TempLiveVideoInfo> getVideoUrl(int roomId);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        abstract public void setVideoUrl(int roomId);
    }
}
