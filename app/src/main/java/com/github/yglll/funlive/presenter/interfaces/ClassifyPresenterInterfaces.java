package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.mvpbase.BaseModel;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;
import java.util.List;

import rx.Observable;


public interface ClassifyPresenterInterfaces {
    interface View extends BaseView {
        void showCateList(List<CateList> list);
        void showCate(List<CapiCategory> list);
    }

    interface Model extends BaseModel {
        Observable<List<CateList>> getCateList();
        Observable<List<CapiCategory>> getCate(String mCloumnName);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void setCateList();
        public abstract void setCate(String cateName);
    }
}
