package com.github.yglll.funlive.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.ClassifyCateActivityModel;
import com.github.yglll.funlive.mvpbase.BaseActivity;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.presenter.impl.ClassifyCateActivityPresenter;
import com.github.yglll.funlive.presenter.interfaces.ClassifyCateActivityInterfaces;
import com.github.yglll.funlive.utils.FullyGridLayoutManager;
import com.github.yglll.funlive.view.adapter.ClassifyCateAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;

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

    @BindView(R.id.refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private CapiCategory capiCategory;
    private ClassifyCateAdapter classifyCateAdapter;

    @Override
    public void showErrorWithStatus(String msg) {
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        Toasty.info(this,msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initView(Bundle bundle) {
        capiCategory=(CapiCategory) getIntent().getSerializableExtra("cate");
        if (capiCategory==null){
            return;
        }

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refresh();
                //refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                mPresenter.setMoreLive();
                //refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });

        if(capiCategory.getTag_id().equals("201")){
            //颜值栏目
            classifyCateAdapter=new ClassifyCateAdapter(this,true);
        }else {
            classifyCateAdapter=new ClassifyCateAdapter(this);
        }
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
        smartRefreshLayout.finishRefresh();
        classifyCateAdapter.setRoomInfos(list);
    }

    @Override
    public void LoadMoreLive(List<RoomInfo> list) {
        smartRefreshLayout.finishLoadMore();
        classifyCateAdapter.setLoadMoreData(list);
    }
}
