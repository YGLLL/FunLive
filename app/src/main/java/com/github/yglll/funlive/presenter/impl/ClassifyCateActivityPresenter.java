package com.github.yglll.funlive.presenter.impl;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.handlingerror.ApiException;
import com.github.yglll.funlive.net.handlingerror.ExceptionEngine;
import com.github.yglll.funlive.net.handlingerror.subscriber.ErrorSubscriber;
import com.github.yglll.funlive.presenter.interfaces.ClassifyCateActivityInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;

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

    private String cateId;
    //默认一次加载的item数
    private int itemLimit=12;
    //偏移量
    private int offset=0;

    @Override
    public void setLiveList(String string) {
        cateId=string;
        itemLimit=12;
        offset=0;
        mModel.getLiveList(string,ParamsMapUtils.getBaseApiDefaultParams(offset,itemLimit)).subscribe(new ErrorSubscriber<List<RoomInfo>>() {
            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<RoomInfo> list) {
                mView.showLiveList(list);
                offset+=itemLimit;
            }
        });
    }
    @Override
    public void setMoreLive() {
        mModel.getLiveList(cateId,ParamsMapUtils.getBaseApiDefaultParams(offset,itemLimit)).subscribe(new ErrorSubscriber<List<RoomInfo>>() {
            @Override
            protected void onError(ApiException ex) {
                if(ex.code== ExceptionEngine.INTERNAL_SERVER_ERROR){
                    mView.showErrorWithStatus(mContext.getResources().getString(R.string.no_more));
                }else {
                    mView.showErrorWithStatus(ex.message);
                }
            }

            @Override
            public void onNext(List<RoomInfo> roomInfos) {
                mView.LoadMoreLive(roomInfos);
                offset+=itemLimit;
            }
        });
    }
}
