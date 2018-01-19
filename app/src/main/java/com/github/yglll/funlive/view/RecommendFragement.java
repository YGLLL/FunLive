package com.github.yglll.funlive.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.RecommendModel;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.mvpbase.BaseFragment;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.RecommendPresenter;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.HomeCarouselAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/14   17:36
 **/
public class RecommendFragement extends BaseFragment<RecommendModel,RecommendPresenter> implements RecommendPresenterInterfaces.View, BGABanner.Delegate<SimpleDraweeView, String> {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private BGABanner bgaBanner;
    private HomeCarouselAdapter homeCarouselAdapter;
    private List<HomeCarousel> homeCarouselList;
    private View haderView;

    @Override
    protected int getLayoutId() {
        return R.layout.recommend_fragement;
    }

    @Override
    public void onInitView(Bundle savedInstanceState){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
            }
        });

        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");
        list.add("n");
        list.add("m");
        list.add("o");
        list.add("p");
        list.add("q");
        RecommendAdapter recommendAdapter=new RecommendAdapter(list);
        haderView = recommendAdapter.setCustomHeaderView(R.layout.item_home_recommend_banner,recyclerView);
        bgaBanner=(BGABanner) haderView.findViewById(R.id.recommed_banner);
        bgaBanner.setDelegate(this);
        bgaBanner.setAdapter(homeCarouselAdapter);

        recyclerView.setAdapter(recommendAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.setCarousel();
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {

    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void showString(String list) {

    }

    @Override
    public void showCarousel(List<HomeCarousel> list) {
        homeCarouselList=list;
        ArrayList<String> pic_url = new ArrayList<String>();
        for (HomeCarousel homeCarousel:list) {
            pic_url.add(homeCarousel.getPic_url());
        }
        if (bgaBanner != null && pic_url.size() > 0) {
            bgaBanner.setData(R.layout.item_image_carousel, pic_url, null);
        }
    }
}
