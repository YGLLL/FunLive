package com.github.yglll.funlive.mvpbase;

import android.content.Context;


public class BasePresenter<V extends BaseView,M extends BaseModel> implements Presenter<V,M> {
    protected Context mContext;
    protected V mView;
    protected M mModel;

    @Override
    public void attachView(V v) {
        this.mView=v;
    }

    @Override
    public void attachModel(M m) {
        this.mModel=m;
    }

    @Override
    public void detachView() {
        this.mView=null;
    }

    @Override
    public void detachModel() {
        this.mModel=null;
    }

    public V getView() {
        return mView;
    }
    public M getModel() {
        return mModel;
    }
    public boolean isViewBind()
    {
        return mView!=null;
    }
}
