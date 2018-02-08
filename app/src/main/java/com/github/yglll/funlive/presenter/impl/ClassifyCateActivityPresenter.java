package com.github.yglll.funlive.presenter.impl;

import com.github.yglll.funlive.model.logic.RoomInfo;
import com.github.yglll.funlive.presenter.interfaces.ClassifyCateActivityInterfaces;

import java.util.List;

import rx.Observer;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/08   9:34
 **/
public class ClassifyCateActivityPresenter extends ClassifyCateActivityInterfaces.Presenter {
    @Override
    public void setLiveList(String string) {
        mModel.getLiveList(string).subscribe(new Observer<List<RoomInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<RoomInfo> list) {
                mView.showLiveList(list);
            }
        });
    }
}
