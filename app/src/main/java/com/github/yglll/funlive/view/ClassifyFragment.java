package com.github.yglll.funlive.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.RecommendModel;
import com.github.yglll.funlive.model.logic.Category;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.model.logic.HomeFaceScoreColumn;
import com.github.yglll.funlive.model.logic.HomeHotColumn;
import com.github.yglll.funlive.model.logic.HomeRecommendHotCate;
import com.github.yglll.funlive.mvpbase.BaseFragment;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.RecommendPresenter;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.orhanobut.logger.Logger;

import java.lang.annotation.Retention;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/14   17:42
 **/
public class ClassifyFragment extends BaseFragment<RecommendModel,RecommendPresenter> implements RecommendPresenterInterfaces.View{

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.classify_fragment;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        mPresenter.setString();
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void showString(String string) {
        textView.setText(string);
    }

    @Override
    public void showCarousel(List<HomeCarousel> list) {

    }

    @Override
    public void showHotColumn(List<HomeHotColumn> list) {

    }

    @Override
    public void showFaceScoreColumn(List<HomeFaceScoreColumn> list) {

    }

    @Override
    public void showHotCate(List<HomeRecommendHotCate> list) {

    }

    @Override
    public void showNavigation(List<Category> list) {

    }
}
