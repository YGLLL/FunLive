package com.github.yglll.funlive.presenter.impl;

import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.handlingerror.ApiException;
import com.github.yglll.funlive.net.handlingerror.subscriber.ErrorSubscriber;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;

import java.util.List;

import rx.Observer;


public class ClassifyPresenter extends ClassifyPresenterInterfaces.Presenter{

    @Override
    public void setCateList() {
        mModel.getCateList().subscribe(new ErrorSubscriber<List<CateList>>() {

            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<CateList> list) {
                mView.showCateList(list);
            }
        });
    }

    @Override
    public void setCate(String cateName) {
        mModel.getCate(cateName).subscribe(new ErrorSubscriber<List<CapiCategory>>() {

            @Override
            protected void onError(ApiException ex) {
                mView.showErrorWithStatus(ex.message);
            }

            @Override
            public void onNext(List<CapiCategory> capiCategories) {
                mView.showCate(capiCategories);
            }
        });
    }
}
