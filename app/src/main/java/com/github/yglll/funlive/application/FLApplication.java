package com.github.yglll.funlive.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/31   23:12
 **/
public class FLApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        //初始化图片加载框架
        Fresco.initialize(this);
    }
}
