package com.github.yglll.funlive.presenter.impl;

import com.github.yglll.funlive.model.logic.CapiCategory;
import com.github.yglll.funlive.model.logic.HomeCate;
import com.github.yglll.funlive.model.logic.Category;
import com.github.yglll.funlive.model.logic.CateList;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/03   18:52
 **/
public class ClassifyPresenter extends ClassifyPresenterInterfaces.Presenter{

    @Override
    public void setCateList() {
        mModel.getCateList().subscribe(new Observer<List<CateList>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CateList> list) {
                mView.showCateList(list);
            }
        });
    }

    @Override
    public void setCate(String cateName) {
        mModel.getCate(cateName).subscribe(new Observer<List<CapiCategory>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<CapiCategory> capiCategories) {
                mView.showCate(capiCategories);
            }
        });
    }
}
