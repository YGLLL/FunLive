package com.github.yglll.funlive.presenter.impl;

import android.text.TextUtils;
import android.util.Log;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.SigninUserManager;
import com.github.yglll.funlive.User;
import com.github.yglll.funlive.presenter.interfaces.SignupContract;
import com.github.yglll.funlive.utils.Utils;
import com.orhanobut.logger.Logger;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import rx.Subscriber;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/12   10:19
 **/
public class SignupPresenter extends SignupContract.Presenter {
    private static final int NAME_FORMAT_ERROR=-1;
    private static final int EMAIL_FORMAT_ERROR=-2;
    private static final int NAME_EXISTS_ERROR=-3;
    private static final int EMAIL_EXISTS_ERROR=-4;
    private static final int ACCOUNT_OR_PASSWORD_ERROR=-5;
    private static final int USER_FREEZED=-6;
    private static final int HUMAN_CODE_ERROR=-7;
    private static final int INVITE_CODE_ERROR=-8;

    private String mUser;
    private String email;
    private String password;
    private String passwordConfirm;
    private String code;
    @Override
    public void signupButtonClick(String user,String email, String password,String passwordConfirm,String code) {
        this.mUser=user;
        this.email=email;
        this.password=password;
        this.passwordConfirm=passwordConfirm;
        this.code=code;
        if (checkUser()){
            if(checkEmail()){
                if(checkPassword()){
                    if(checkPasswordDiff()){
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
                        mView.passwordError(mContext.getString(R.string.password_diff));
                    }
                }else {
                    mView.passwordError(mContext.getString(R.string.password_empty));
                }
            }else {
                mView.emailError(mContext.getString(R.string.email_empty));
            }
        }else {
            mView.userNameError(mContext.getString(R.string.account_empty));
        }
    }

    public void commit(){
        //提交数据
        mModel.signup();
        User user=new User();
        user.setName(mUser);
        user.setPwd(password);
        user.setId(String.valueOf(System.currentTimeMillis()));
        if(SigninUserManager.addUser(mContext,user)){
            mView.signupSuccessful();
        }else {
            mView.showErrorWithStatus("用户已存在");
        }
    }

    private void disposeStatus(int i){
        if(i<0){
            //失败
            switch (i){
                case NAME_FORMAT_ERROR:
                    mView.userNameError(mContext.getString(R.string.name_format_error));
                    break;
                case EMAIL_FORMAT_ERROR:
                    mView.emailError(mContext.getString(R.string.email_format_error));
                    break;
                case NAME_EXISTS_ERROR:
                    mView.userNameError(mContext.getString(R.string.name_exists_error));
                    break;
                case EMAIL_EXISTS_ERROR:
                    mView.emailError(mContext.getString(R.string.email_exists_error));
                    break;
                case ACCOUNT_OR_PASSWORD_ERROR:
                    mView.showErrorWithStatus(mContext.getString(R.string.account_or_password_error));
                    break;
                case USER_FREEZED:
                    mView.showErrorWithStatus(mContext.getString(R.string.user_freezed));
                    break;
                case HUMAN_CODE_ERROR:
                    mView.codeError(mContext.getString(R.string.human_code_error));
                    break;
                case INVITE_CODE_ERROR:
                    mView.showErrorWithStatus(mContext.getString(R.string.invite_code_error));
                    break;
                default:
                    mView.showErrorWithStatus(mContext.getString(R.string.unknown_error)+i);
            }
            mView.refreshCodeImg();
        }else {
            //注册成功
            mView.signupSuccessful();
        }
    }

    private Boolean checkUser(){
        return !TextUtils.isEmpty(mUser);
    }
    private Boolean checkEmail(){
        return !TextUtils.isEmpty(email);
    }
    private Boolean checkPassword(){
        return !TextUtils.isEmpty(password);
    }
    private Boolean checkPasswordDiff(){
        if(password.equals(passwordConfirm)){
            return true;
        }else {
            return false;
        }
    }
    private Boolean checkCode(){
        return !TextUtils.isEmpty(code);
    }
}
