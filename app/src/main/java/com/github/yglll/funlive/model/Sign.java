package com.github.yglll.funlive.model;

import com.github.yglll.funlive.mvpbase.BaseModel;


public interface Sign extends BaseModel {
    void signin();
    void signup();
    void getUserInfo();
}