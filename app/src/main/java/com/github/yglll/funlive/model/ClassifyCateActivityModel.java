package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.FunLiveAPI;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.ClassifyCateActivityInterfaces;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/08   9:35
 **/
public class ClassifyCateActivityModel implements ClassifyCateActivityInterfaces.Model {
    @Override
    public Observable<List<RoomInfo>> getLiveList(String string,Map<String,Integer> map) {
        return new RetrofitClient()
                .builder(FunLiveAPI.class)
                .getRoomList(string, map)
                //拦截并处理错误
                .compose(new DefaultTransformer<List<RoomInfo>>());
    }
}
