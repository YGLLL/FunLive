package com.github.yglll.funlive.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.ClassifyCateActivityModel;
import com.github.yglll.funlive.model.logic.CapiCategory;
import com.github.yglll.funlive.model.logic.RoomInfo;
import com.github.yglll.funlive.mvpbase.BaseActivity;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.ClassifyCateActivityPresenter;
import com.github.yglll.funlive.presenter.interfaces.ClassifyCateActivityInterfaces;
import com.github.yglll.funlive.utils.FullyGridLayoutManager;
import com.github.yglll.funlive.view.adapter.ClassifyCateAdapter;
import com.github.yglll.funlive.view.adapter.ClassifyGridAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/08   0:45
 **/
public class ClassifyCateActivity extends BaseActivity<ClassifyCateActivityModel,ClassifyCateActivityPresenter> implements ClassifyCateActivityInterfaces.View {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private CapiCategory capiCategory;
    private ClassifyCateAdapter classifyCateAdapter;

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void initView(Bundle bundle) {
        capiCategory=(CapiCategory) getIntent().getSerializableExtra("cate");
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        classifyCateAdapter=new ClassifyCateAdapter(this);
        recyclerView.setAdapter(classifyCateAdapter);
        recyclerView.setLayoutManager(new FullyGridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }

    @Override
    public void onStart(){
        super.onStart();
        refresh();
    }

    private void refresh(){
        mPresenter.setLiveList(capiCategory.getTag_id());
    }

    @Override
    public String activityTitle() {
        return capiCategory.getTag_name();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_classify_cate;
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void showLiveList(List<RoomInfo> list) {
        classifyCateAdapter.setRoomInfos(list);
    }
}
