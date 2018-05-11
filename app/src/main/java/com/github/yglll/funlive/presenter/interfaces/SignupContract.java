package com.github.yglll.funlive.presenter.interfaces;


import com.github.yglll.funlive.model.Sign;
import com.github.yglll.funlive.mvpbase.BasePresenter;
import com.github.yglll.funlive.mvpbase.BaseView;


public interface SignupContract {
    interface View extends BaseView {
        void userNameError(String message);
        void emailError(String message);
        void passwordError(String message);
        void codeError(String message);
        void signupSuccessful();
        void showProgressDialog();
        void closeProgressDialog();
        void refreshCodeImg();
    }

    abstract class Presenter extends BasePresenter<View,Sign> {
        public abstract void signupButtonClick(String user,String email,String password,String passwordConfirm,String code);
    }
}
