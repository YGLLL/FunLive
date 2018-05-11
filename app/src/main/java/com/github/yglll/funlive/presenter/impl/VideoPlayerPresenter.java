package com.github.yglll.funlive.presenter.impl;

import android.widget.Toast;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.TempLiveVideoInfo;
import com.github.yglll.funlive.net.handlingerror.ApiException;
import com.github.yglll.funlive.net.handlingerror.subscriber.ErrorSubscriber;
import com.github.yglll.funlive.presenter.interfaces.VideoPlayerInterfaces;
import com.orhanobut.logger.Logger;

import java.util.List;

import es.dmoral.toasty.Toasty;
import rx.Observer;


public class VideoPlayerPresenter extends VideoPlayerInterfaces.Presenter {
    @Override
    public void setVideoUrl(int roomId) {
        mModel.getVideoUrl(roomId).subscribe(new ErrorSubscriber<TempLiveVideoInfo>() {

            @Override
            protected void onError(ApiException ex) {
                if(ex.message.equals("系统错误")){
                    mView.showErrorWithStatus(mContext.getString(R.string.anchor_absent));
                }else {
                    mView.showErrorWithStatus(ex.message);
                }
            }

            @Override
            public void onNext(TempLiveVideoInfo tempLiveVideoInfo) {
                mView.acquisitionVideoUrl(tempLiveVideoInfo.getHls_url());
            }
        });
    }
}
