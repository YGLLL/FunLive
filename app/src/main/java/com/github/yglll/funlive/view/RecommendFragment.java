package com.github.yglll.funlive.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.RecommendModel;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.mvpbase.BaseFragment;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.presenter.impl.RecommendPresenter;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.recommend.CarouselAdapter;
import com.github.yglll.funlive.view.adapter.recommend.NavigationAdapter;
import com.github.yglll.funlive.view.adapter.recommend.RecommendAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/14   17:36
 **/
public class RecommendFragment extends BaseFragment<RecommendModel,RecommendPresenter> implements RecommendPresenterInterfaces.View, BGABanner.Delegate<SimpleDraweeView, String> {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private BGABanner bgaBanner;
    private CarouselAdapter carouselAdapter;
    private List<HomeCarousel> homeCarouselList;
    private View haderView;
    private RecommendAdapter recommendAdapter;
    private NavigationAdapter navigationAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragement_recommend;
    }

    @Override
    public void onInitView(Bundle savedInstanceState){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        recommendAdapter=new RecommendAdapter(getActivity());

        haderView = recommendAdapter.setCustomHeaderView(R.layout.recommend_carousel,recyclerView);
        bgaBanner=(BGABanner) haderView.findViewById(R.id.recommed_banner);
        bgaBanner.setDelegate(this);
        carouselAdapter =new CarouselAdapter();
        bgaBanner.setAdapter(carouselAdapter);

        View navigationView=recommendAdapter.setNavigationView(R.layout.recommend_navigation,recyclerView);
        //todo 使navigationView风格与其他item保持一致
        GridView gridView=navigationView.findViewById(R.id.grid_view);
        navigationAdapter=new NavigationAdapter();
        gridView.setAdapter(navigationAdapter);

        recyclerView.setAdapter(recommendAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void refresh(){
        mPresenter.setCarousel();
        mPresenter.setHotColumn();
        mPresenter.setFaceScoreColumn();
        mPresenter.setHotCate();
        mPresenter.setNavigation();
    }

    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {
        HomeCarousel homeCarousel=homeCarouselList.get(position);
        Intent intent=new Intent(getActivity(),VideoPlayer.class);
        intent.putExtra("roomInfo", RoomInfo.valueOf(homeCarousel.getRoom()));
        if(homeCarousel.getRoom().getCate_id().equals("201")){
            //竖屏播放
            intent.putExtra("screenMode",true);
            getActivity().startActivity(intent);
        }else {
            //横屏播放
            getActivity().startActivity(intent);
        }
    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void showCarousel(List<HomeCarousel> list) {
        homeCarouselList=list;
        ArrayList<String> pic_url = new ArrayList<String>();
        for (HomeCarousel homeCarousel:list) {
            pic_url.add(homeCarousel.getPic_url());
        }
        if (bgaBanner != null && pic_url.size() > 0) {
            bgaBanner.setData(R.layout.item_carousel, pic_url, null);
        }
    }

    @Override
    public void showHotColumn(List<RoomInfo> list) {
        recommendAdapter.setHomeHotColumns(list);
    }

    @Override
    public void showFaceScoreColumn(List<RoomInfo> list) {
        recommendAdapter.setHomeFaceScoreColumns(list);
    }

    @Override
    public void showHotCate(List<HomeCate> list) {
        recommendAdapter.setHomeCates(list);
    }

    @Override
    public void showNavigation(List<Category> list) {
        navigationAdapter.setData(list);
    }
}
