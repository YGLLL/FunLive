package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;

import rx.Observable;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/03   18:53
 **/
public class ClassifyModel implements ClassifyPresenterInterfaces.Model {
    @Override
    public Observable<List<CateList>> getCateList() {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getCateList(ParamsMapUtils.getDefaultParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<CateList>>());
    }

    @Override
    public Observable<List<CapiCategory>> getCate(String mCloumnName) {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getCapiCategory(ParamsMapUtils.getLiveOtherTwoColumn(mCloumnName))
                //拦截并处理错误
                .compose(new DefaultTransformer<List<CapiCategory>>());
    }
}
