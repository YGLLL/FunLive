package com.github.yglll.funlive.mvpbase;


public interface Presenter<V,M> {
    //绑定View
    void attachView(V v);
    //绑定Model
    void attachModel(M m);
    //解绑View
    void detachView();
    //解绑Model
    void detachModel();
}
