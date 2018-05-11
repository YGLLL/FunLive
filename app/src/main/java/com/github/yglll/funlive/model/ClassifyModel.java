package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.FunLiveAPI;
import com.github.yglll.funlive.api.APILocation;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.net.handlingerror.DefaultTransformer;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;
import com.github.yglll.funlive.utils.ParamsMapUtils;

import java.util.List;

import rx.Observable;


public class ClassifyModel implements ClassifyPresenterInterfaces.Model {
    @Override
    public Observable<List<CateList>> getCateList() {
        return new RetrofitClient()
                .setBaseUrl(APILocation.baseUrl_capi)
                .builder(FunLiveAPI.class)
                .getCateList(ParamsMapUtils.getDefaultParams())
                //拦截并处理错误
                .compose(new DefaultTransformer<List<CateList>>());
    }

    @Override
    public Observable<List<CapiCategory>> getCate(String mCloumnName) {
        return new RetrofitClient()
                .setBaseUrl(APILocation.baseUrl_capi)
                .builder(FunLiveAPI.class)
                .getCapiCategory(ParamsMapUtils.getLiveOtherTwoColumn(mCloumnName))
                //拦截并处理错误
                .compose(new DefaultTransformer<List<CapiCategory>>());
    }
}
