package com.github.yglll.funlive.model;

import com.github.yglll.funlive.mvpbase.BaseModel;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/12   10:24
 **/
public interface Sign extends BaseModel {
    void signin();
    void signup();
    void getUserInfo();
}