package com.github.yglll.funlive.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.SignModel;
import com.github.yglll.funlive.mvpbase.BaseActivity;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.SignupPresenter;
import com.github.yglll.funlive.presenter.interfaces.SignupContract;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/12   9:37
 **/
public class SignupActivity extends BaseActivity<SignModel, SignupPresenter> implements SignupContract.View {

    @BindView(R.id.user_name)
    BootstrapEditText userName;
    @BindView(R.id.password)
    BootstrapEditText password;
    @BindView(R.id.password_confirm)
    BootstrapEditText passwordConfirm;
    @BindView(R.id.signup_button)
    BootstrapButton signupButton;
    private ProgressDialog progressDialog;

    @Override
    public void initView(Bundle s) {
        //QMUIStatusBarHelper.translucent(this);//沉浸式状态栏
    }

    @Override
    public String activityTitle() {
        return "注册FunLive";
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void refreshCodeImg(){
    }

    @OnClick(R.id.signup_button)
    public void onSignup(){
        showProgressDialog();
        mPresenter.signupButtonClick(userName.getText().toString(),
                "email",
                password.getText().toString(),
                passwordConfirm.getText().toString(),
                "code");
    }

    @Override
    public void showErrorWithStatus(String msg) {
        closeProgressDialog();
        showToast(getString(R.string.error)+msg);
    }

    @Override
    public void userNameError(String message) {
        closeProgressDialog();
        userName.setError(message);
    }

    @Override
    public void emailError(String message) {
        closeProgressDialog();
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
    public void signupSuccessful() {
        closeProgressDialog();
        showToast(getString(R.string.signup_successful));
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signup;
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    /**   * 显示进度对话框   */
    @Override
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getResources().getString(R.string.please_wait));
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
}
