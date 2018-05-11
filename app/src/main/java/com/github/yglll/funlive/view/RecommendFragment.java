package com.github.yglll.funlive.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.application.FLApplication;
import com.github.yglll.funlive.model.RecommendModel;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.FunLiveRoom;
import com.github.yglll.funlive.net.bean.HomeCarousel;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.mvpbase.BaseFragment;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.net.bean.HttpResponse;
import com.github.yglll.funlive.presenter.impl.RecommendPresenter;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.recommend.CarouselAdapter;
import com.github.yglll.funlive.view.adapter.recommend.NavigationAdapter;
import com.github.yglll.funlive.view.adapter.recommend.RecommendAdapter;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;
import es.dmoral.toasty.Toasty;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class RecommendFragment extends BaseFragment<RecommendModel,RecommendPresenter> implements RecommendPresenterInterfaces.View, BGABanner.Delegate<SimpleDraweeView, String> {

    @BindView(R.id.refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private BGABanner bgaBanner;
    private CarouselAdapter carouselAdapter;
    private List<HomeCarousel> homeCarouselList;
    private View haderView;
    private RecommendAdapter recommendAdapter;
    private NavigationAdapter navigationAdapter;
    private CarouselTask carouselTask;
    private final String carouselUrl="http://capi.douyucdn.cn/api/v1/slide/6";

    @Override
    protected int getLayoutId() {
        return R.layout.fragement_recommend;
    }

    @Override
    public void onInitView(Bundle savedInstanceState){
        recommendAdapter=new RecommendAdapter(getActivity());

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                refresh();
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPresenter.setMoreHotCates();
            }
        });

        haderView = recommendAdapter.setCarouselView(R.layout.recommend_carousel,recyclerView);
        bgaBanner=(BGABanner) haderView.findViewById(R.id.recommed_banner);
        bgaBanner.setDelegate(this);
        carouselAdapter =new CarouselAdapter();
        bgaBanner.setAdapter(carouselAdapter);

        View navigationView=recommendAdapter.setNavigationView(R.layout.recommend_navigation,recyclerView);
        GridView gridView=navigationView.findViewById(R.id.grid_view);
        navigationAdapter=new NavigationAdapter();
        gridView.setAdapter(navigationAdapter);

        recyclerView.setAdapter(recommendAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        smartRefreshLayout.autoRefresh();
    }

    private void refresh(){
        recommendAdapter.clear();
        //mPresenter.setCarousel();
        carouselTask=new CarouselTask();
        carouselTask.execute();
        mPresenter.setNavigation();
        mPresenter.setHotColumn();
        mPresenter.setFaceScoreColumn();
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {
        HomeCarousel homeCarousel=homeCarouselList.get(position);
        VideoPlayer.startActivity(getActivity(), FunLiveRoom.valueOf(homeCarousel.getRoom()));
    }

    @Override
    public void showErrorWithStatus(String msg) {
        smartRefreshLayout.finishLoadMore();
        smartRefreshLayout.finishRefresh();
        Toasty.info(getActivity(),msg, Toast.LENGTH_SHORT).show();
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
    public void showHotColumn(List<HomeHotColumn> list) {
        recommendAdapter.setHomeHotColumns(list);
    }

    @Override
    public void showFaceScoreColumn(List<RoomInfo> list) {
        recommendAdapter.setHomeFaceScoreColumns(list);
    }

    @Override
    public void showNavigation(List<Category> list) {
        navigationAdapter.setData(list);
    }

    @Override
    public void showHotCates(List<Category> categories, List<List<RoomInfo>> roomList) {
        smartRefreshLayout.finishRefresh();
        smartRefreshLayout.finishLoadMore();
        recommendAdapter.setData(categories,roomList);
    }

    @Override
    public void onResume(){
        super.onResume();
        //google analytics
        FLApplication application = (FLApplication) getActivity().getApplication();
        Tracker mTracker = application.getDefaultTracker();

        mTracker.setScreenName(RecommendFragment.class.toString());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    //AsyncTask
    class CarouselTask extends AsyncTask<Object,Object,List<HomeCarousel>> {

        @Override
        protected List<HomeCarousel> doInBackground(Object... objects) {
            Request request=new Request.Builder().url(carouselUrl).build();
            OkHttpClient client=new OkHttpClient();
            try {
                Response response=client.newCall(request).execute();
                final String responseData=response.body().string();
                if (!TextUtils.isEmpty(responseData)){
                    return analysisJson(responseData);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return new ArrayList<>();
        }

        private List<HomeCarousel> analysisJson(String jsonStr){
            Gson gson=new Gson();
            try {
                JSONObject response=new JSONObject(jsonStr);
                int error=response.getInt("error");
                if(error!=0) {
                    return new ArrayList<>();
                }else{
                    Type type=new TypeToken<List<HomeCarousel>>(){}.getType();
                    return gson.fromJson(response.getString("data"),type);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }

        @Override
        protected void onPostExecute(List<HomeCarousel> list){
            super.onPostExecute(list);
            showCarousel(list);
        }
    }
}
