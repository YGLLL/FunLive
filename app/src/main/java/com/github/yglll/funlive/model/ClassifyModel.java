package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.api.NetWorkAPI;
import com.github.yglll.funlive.model.logic.CapiCategory;
import com.github.yglll.funlive.model.logic.HomeCate;
import com.github.yglll.funlive.model.logic.CateList;
import com.github.yglll.funlive.model.logic.Category;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.transformer.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;

import rx.Observable;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
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
                .compose(new DefaultTransformer<List<CateList>>());
    }

    @Override
    public Observable<List<CapiCategory>> getCate(String mCloumnName) {
        return new RetrofitClient()
                .setBaseUrl(NetWorkAPI.baseUrl_capi)
                .builder(Live.class)
                .getCapiCategory(ParamsMapUtils.getLiveOtherTwoColumn(mCloumnName))
                .compose(new DefaultTransformer<List<CapiCategory>>());
    }
}
