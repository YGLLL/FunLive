package com.github.yglll.funlive.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.ClassifyModel;
import com.github.yglll.funlive.model.logic.CapiCategory;
import com.github.yglll.funlive.model.logic.CateList;
import com.github.yglll.funlive.mvpbase.BaseFragment;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.ClassifyPresenter;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.ClassifyAdapter;
import com.github.yglll.funlive.view.adapter.ClassifyGridAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/06   11:20
 **/
public class ClassifyChildrenFragment extends BaseFragment<ClassifyModel,ClassifyPresenter> implements ClassifyPresenterInterfaces.View{

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.grid_view)
    GridView gridView;

    private ClassifyGridAdapter classifyGridAdapter;
    private String cateName="";

    @Override
    protected int getLayoutId() {
        return R.layout.item_classify;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        cateName=getArguments().getString(ClassifyAdapter.CATENAMEKEY,"");
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        classifyGridAdapter=new ClassifyGridAdapter();
        gridView.setAdapter(classifyGridAdapter);
    }

    private void refresh(){
        mPresenter.setCate(cateName);
    }

    @Override
    public void onStart(){
        super.onStart();
        refresh();
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void showCateList(List<CateList> list) {

    }

    @Override
    public void showCate(List<CapiCategory> list) {
        classifyGridAdapter.setData(list);
    }
}
