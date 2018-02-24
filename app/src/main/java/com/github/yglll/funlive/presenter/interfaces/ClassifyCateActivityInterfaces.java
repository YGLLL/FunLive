package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.mvpbase.BaseModel;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/08   9:30
 **/
public interface ClassifyCateActivityInterfaces {
    interface View extends BaseView {
        void showLiveList(List<RoomInfo> list);
        void LoadMoreLive(List<RoomInfo> list);
    }

    interface Model extends BaseModel {
        Observable<List<RoomInfo>> getLiveList(String string, Map<String,Integer> map);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        abstract public void setLiveList(String string);
        abstract public void setMoreLive();
    }
}
