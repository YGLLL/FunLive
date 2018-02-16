package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.net.gsonmodel.CapiCategory;
import com.github.yglll.funlive.net.gsonmodel.CateList;
import com.github.yglll.funlive.mvpbase.BaseModel;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;
import java.util.List;

import rx.Observable;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/03   18:44
 **/
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
