package com.github.yglll.funlive.mvpbase;

import android.content.Context;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：定义每一个Presenter都应该具备的基本属性
 * 备注消息：
 * 创建时间：2018/01/10   21:46
 **/
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
