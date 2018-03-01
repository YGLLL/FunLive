package com.github.yglll.funlive.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.ClassifyModel;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.mvpbase.BaseFragment;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.ClassifyPresenter;
import com.github.yglll.funlive.presenter.interfaces.ClassifyPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.classify.ClassifyAdapter;
import com.github.yglll.funlive.view.adapter.classify.ClassifyGridAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/06   11:20
 **/
public class ClassifyGridFragment extends BaseFragment<ClassifyModel,ClassifyPresenter> implements ClassifyPresenterInterfaces.View{

    @BindView(R.id.refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.grid_view)
    GridView gridView;

    private ClassifyGridAdapter classifyGridAdapter;
    private String cateName="";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item_classify;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        cateName=getArguments().getString(ClassifyAdapter.CATENAMEKEY,"");
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh();
                smartRefreshLayout.finishRefresh();
            }
        });

        classifyGridAdapter=new ClassifyGridAdapter();
        gridView.setAdapter(classifyGridAdapter);

        refresh();
    }

    private void refresh(){
        mPresenter.setCate(cateName);
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void showErrorWithStatus(String msg) {
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        Toasty.info(getActivity(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCateList(List<CateList> list) {

    }

    @Override
    public void showCate(List<CapiCategory> list) {
        classifyGridAdapter.setData(list);
    }
}
