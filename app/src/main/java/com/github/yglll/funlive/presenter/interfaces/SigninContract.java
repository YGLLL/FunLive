package com.github.yglll.funlive.presenter.interfaces;


import com.github.yglll.funlive.model.Sign;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/10   20:42
 **/
public interface SigninContract {
    interface View extends BaseView {
        void accountError(String message);
        void passwordError(String message);
        void codeError(String message);
        void signinSuccessful(String user);
        void showProgressDialog();
        void closeProgressDialog();
        void refreshCodeImg();
    }

    abstract class Presenter extends BasePresenter<View,Sign> {
        public abstract void signinButtonClick(String account,String password,String code);
    }
}
