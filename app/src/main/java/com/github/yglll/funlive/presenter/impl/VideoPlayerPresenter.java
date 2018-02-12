package com.github.yglll.funlive.presenter.impl;

import com.github.yglll.funlive.model.logic.TempLiveVideoInfo;
import com.github.yglll.funlive.presenter.interfaces.VideoPlayerInterfaces;
import com.orhanobut.logger.Logger;

import rx.Observer;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/10   22:53
 **/
public class VideoPlayerPresenter extends VideoPlayerInterfaces.Presenter {
    @Override
    public void setVideoUrl(int roomId) {
        mModel.getVideoUrl(roomId).subscribe(new Observer<TempLiveVideoInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TempLiveVideoInfo tempLiveVideoInfo) {
                Logger.i("onNext(TempLiveVideoInfo tempLiveVideoInfo)");
                mView.acquisitionVideoUrl(tempLiveVideoInfo.getHls_url());
            }
        });
    }
}
