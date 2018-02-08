package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.model.logic.CateList;
import com.github.yglll.funlive.model.logic.RoomInfo;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.transformer.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.ClassifyCateActivityInterfaces;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/08   9:35
 **/
public class ClassifyCateActivityModel implements ClassifyCateActivityInterfaces.Model {
    @Override
    public Observable<List<RoomInfo>> getLiveList(String string) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("offset", 0);
        map.put("limit", 12);
        return new RetrofitClient()
                .builder(Live.class)
                .getLiveList(string, map)
                .compose(new DefaultTransformer<List<RoomInfo>>());
    }
}
