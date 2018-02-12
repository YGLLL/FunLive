package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.model.logic.TempLiveVideoInfo;
import com.github.yglll.funlive.net.Response.HttpResponse;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.transformer.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.VideoPlayerInterfaces;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;

import static com.github.yglll.funlive.api.NetWorkAPI.baseUrl_capi;
import static com.github.yglll.funlive.api.NetWorkAPI.baseUrl_m;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
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
                .builder(Live.class)
                .getVideoUrl(map)
                //必须compose，不然会出现线程错误
                .compose(new DefaultTransformer<TempLiveVideoInfo>());
    }
}
