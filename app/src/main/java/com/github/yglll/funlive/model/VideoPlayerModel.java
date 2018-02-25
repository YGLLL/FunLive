package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.FunLiveAPI;
import com.github.yglll.funlive.net.bean.TempLiveVideoInfo;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.VideoPlayerInterfaces;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

import static com.github.yglll.funlive.api.APILocation.baseUrl_m;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/10   22:44
 **/
public class VideoPlayerModel implements VideoPlayerInterfaces.Model {
    @Override
    public Observable<TempLiveVideoInfo> getVideoUrl(int roomId) {
        Map<String,Integer> map=new HashMap<>();
        map.put("roomId",roomId);
        return new RetrofitClient()
                .setBaseUrl(baseUrl_m)
                .builder(FunLiveAPI.class)
                .getVideoUrl(map)
                //必须compose，不然会出现线程错误
                //拦截并处理错误
                .compose(new DefaultTransformer<TempLiveVideoInfo>());
    }
}
