package com.github.yglll.funlive.presenter.interfaces;


import com.github.yglll.funlive.model.Sign;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;


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
