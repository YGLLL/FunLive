package com.github.yglll.funlive.view;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.SignModel;
import com.github.yglll.funlive.mvpbase.BaseActivity;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.SigninPresenter;
import com.github.yglll.funlive.presenter.interfaces.SigninContract;

import butterknife.BindView;
import butterknife.OnClick;


public class SigninActivity extends BaseActivity<SignModel, SigninPresenter> implements SigninContract.View {
    @BindView(R.id.account)
    BootstrapEditText account;
    @BindView(R.id.password)
    BootstrapEditText password;
    @BindView(R.id.signin_button)
    BootstrapButton signinButton;
    @BindView(R.id.signup_button)
    BootstrapButton signupButton;
    private ProgressDialog progressDialog;

    @Override
    public void initView(Bundle s) {
        //QMUIStatusBarHelper.translucent(this);//沉浸式状态栏
    }

    @Override
    public String activityTitle() {
        return "登录FunLive";
    }

    @OnClick(R.id.signin_button)
    public void signin(){
        showProgressDialog();
        mPresenter.signinButtonClick(account.getText().toString(), password.getText().toString(),"code");
    }

    @OnClick(R.id.signup_button)
    public void signup(){
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.reset_password)
    public void resetPassword(){
//        Intent i = new Intent(this, WebActivity.class);
//        i.putExtra("url",Constant.resetPassword);
//        startActivity(i);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signin;
    }

    @Override
    public void accountError(String message) {
        closeProgressDialog();
        account.setError(message);
    }

    @Override
    public void passwordError(String message) {
        closeProgressDialog();
        password.setError(message);
    }

    @Override
    public void codeError(String message) {
        closeProgressDialog();
    }

    @Override
    public void signinSuccessful(String user) {
        closeProgressDialog();
        showToast("登录成功");
        finish();
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void showErrorWithStatus(String msg) {
        closeProgressDialog();
        showToast(getString(R.string.error)+msg);
    }
    /**   * 显示进度对话框   */
    @Override
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("登录中");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }
    /**   * 关闭进度对话框   */
    @Override
    public void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void refreshCodeImg() {

    }

    @Override
    public Boolean isGoHome(){
        return false;
    }
}
