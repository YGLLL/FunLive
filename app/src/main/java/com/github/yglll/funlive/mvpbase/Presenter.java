package com.github.yglll.funlive.mvpbase;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/10   21:48
 **/
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
