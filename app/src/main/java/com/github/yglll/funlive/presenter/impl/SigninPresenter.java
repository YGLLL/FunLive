package com.github.yglll.funlive.presenter.impl;

import android.text.TextUtils;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.SigninUserManager;
import com.github.yglll.funlive.User;
import com.github.yglll.funlive.presenter.interfaces.SigninContract;
import com.github.yglll.funlive.utils.Utils;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SigninPresenter extends SigninContract.Presenter {
    private static final int NAME_FORMAT_ERROR=-1;
    private static final int EMAIL_FORMAT_ERROR=-2;
    private static final int NAME_EXISTS_ERROR=-3;
    private static final int EMAIL_EXISTS_ERROR=-4;
    private static final int ACCOUNT_OR_PASSWORD_ERROR=-5;
    private static final int USER_FREEZED=-6;
    private static final int HUMAN_CODE_ERROR=-7;
    private static final int INVITE_CODE_ERROR=-8;

    private String account;
    private String password;
    private String code;
    @Override
    public void signinButtonClick(String account,String password,String code) {
        this.account=account;
        this.password=password;
        this.code=code;
        //检查用户名
        if (checkAccount()){
            //检查密码
            if (checkPassword()){
                if(checkCode()){
                    if(Utils.isNetworkConnected(mContext)){
                        TimerTask task = new TimerTask(){
                            public void run(){
                                commit();
                            }
                        };
                        Timer timer = new Timer();
                        timer.schedule(task, new Random().nextInt(1000));
                    }else {
                        mView.showErrorWithStatus("网络未连接");
                    }
                }else {
                    mView.codeError(mContext.getString(R.string.code_empty));
                }
            }else {
                mView.passwordError(mContext.getString(R.string.password_empty));
            }
        }else {
            mView.accountError(mContext.getString(R.string.account_empty));
        }
    }

    private void commit(){
        //提交
        mModel.signin();
        User user=new User();
        user.setName(account);
        user.setPwd(password);
        switch (SigninUserManager.userSignin(mContext,user)){
            case SigninUserManager.NOUSER:
                mView.showErrorWithStatus("没有此用户");
                break;
            case SigninUserManager.PWDERROR:
                mView.showErrorWithStatus("密码错误");
                break;
            case SigninUserManager.SIGNINSU:
                mView.signinSuccessful("");
                break;
                default:
                    mView.showErrorWithStatus(mContext.getString(R.string.unknown_error));
        }
    }

    private Boolean checkAccount(){
        return !TextUtils.isEmpty(account);
    }
    private Boolean checkPassword(){
        return !TextUtils.isEmpty(password);
    }
    private Boolean checkCode(){
        return !TextUtils.isEmpty(code);
    }
}
