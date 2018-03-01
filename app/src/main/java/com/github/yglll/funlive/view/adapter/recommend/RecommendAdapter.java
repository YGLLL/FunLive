package com.github.yglll.funlive.view.adapter.recommend;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.net.bean.HomeCate;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.view.CateActivity;
import com.github.yglll.funlive.view.adapter.RoomListAdapter;
import com.github.yglll.funlive.view.manager.FullyGridLayoutManager;
import com.github.yglll.funlive.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/18   18:40
 **/
public class RecommendAdapter extends RecyclerView.Adapter {

    private List<HomeHotColumn> homeHotColumns;
    private List<RoomInfo> homeFaceScoreColumns;

    private List<List<RoomInfo>> data;
    private List<Category> categories;

    private RoomListAdapter roomListAdapter;

    private Context mContext;

    protected View carouselView=null;
    protected View navigationView=null;

    public RecommendAdapter(Context context){
        this.mContext=context;
        homeHotColumns=new ArrayList<>();
        homeFaceScoreColumns=new ArrayList<>();
        categories=new ArrayList<>();
        data =new ArrayList<>();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {
        //栏目图标
        public ImageView cateImage;
        //栏目名称
        public TextView tv_column_name;
        //加载更多
        public RelativeLayout rl_column_more;
        //栏目列表
        public RecyclerView rv_column_list;

        public LinearLayout item_home_recommed_girdview;

        public NormalViewHolder(View itemView) {
            super(itemView);
            cateImage=(ImageView) itemView.findViewById(R.id.cate_icon);
            tv_column_name = (TextView) itemView.findViewById(R.id.tv_column_name);
            rl_column_more = (RelativeLayout) itemView.findViewById(R.id.rl_column_more);
            rv_column_list = (RecyclerView) itemView.findViewById(R.id.rv_column_list);
            item_home_recommed_girdview = (LinearLayout) itemView.findViewById(R.id.item_home_recommed_girdview);
        }
    }
    static class CustomViewHolder extends RecyclerView.ViewHolder{
        public CustomViewHolder(View view){
            super(view);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE.CAROUSEL:
                return new CustomViewHolder(carouselView);
            case VIEW_TYPE.NAVIGATION:
                return new CustomViewHolder(navigationView);
            default:
                return new NormalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof NormalViewHolder){
            position-=2;
            NormalViewHolder normalViewHolder=(NormalViewHolder)holder;
            switch (position){
                case 0:
                    normalViewHolder.rl_column_more.setVisibility(View.GONE);
                    normalViewHolder.tv_column_name.setText("热门");
                    normalViewHolder.rv_column_list.setLayoutManager(new FullyGridLayoutManager(normalViewHolder.rv_column_list.getContext(), 2, GridLayoutManager.VERTICAL, false));
                    HomeHotColumnAdapter homeHotColumnAdapter=new HomeHotColumnAdapter(mContext,homeHotColumns);
                    normalViewHolder.rv_column_list.setAdapter(homeHotColumnAdapter);
                    break;
                case 1:
                    normalViewHolder.rl_column_more.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            CapiCategory capiCategory=new CapiCategory();
                            capiCategory.setTag_name("颜值");
                            capiCategory.setTag_id("201");
                            CateActivity.startActivity(mContext,capiCategory);
                        }
                    });
                    normalViewHolder.tv_column_name.setText("颜值");
                    normalViewHolder.rv_column_list.setLayoutManager(new FullyGridLayoutManager(normalViewHolder.rv_column_list.getContext(), 2, GridLayoutManager.VERTICAL, false));
                    roomListAdapter =new RoomListAdapter(mContext,homeFaceScoreColumns,true);
                    normalViewHolder.rv_column_list.setAdapter(roomListAdapter);
                    break;
                default:
                    if(data.size()>0){
                        final int i=position-2;
                        normalViewHolder.rl_column_more.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                CateActivity.startActivity(mContext,CapiCategory.valueOf(categories.get(i)));
                            }
                        });
                        normalViewHolder.tv_column_name.setText(categories.get(i).getGame_name());
                        normalViewHolder.rv_column_list.setLayoutManager(new FullyGridLayoutManager(normalViewHolder.rv_column_list.getContext(), 2, GridLayoutManager.VERTICAL, false));
                        roomListAdapter=new RoomListAdapter(mContext,data.get(i));
                        normalViewHolder.rv_column_list.setAdapter(roomListAdapter);
                    }
            }
        }
    }



    @Override
    public int getItemCount() {
        return data.size()+getOtherCount();
    }

    private int getOtherCount(){
        int i=0;
        if (carouselView!=null)i++;
        if(navigationView!=null)i++;
        if(homeHotColumns.size()>0)i++;
        if(homeFaceScoreColumns.size()>0)i++;
        return i;
    }

    @Override
    public final int getItemViewType(int position){
        switch (position){
            case 0:
                return VIEW_TYPE.CAROUSEL;
            case 1:
                return VIEW_TYPE.NAVIGATION;
            case 2:
                return VIEW_TYPE.HOT;
            case 3:
                return VIEW_TYPE.FACE;
            default:
                return VIEW_TYPE.NORMAL;
        }
    }

    public View setCarouselView(@LayoutRes int id,RecyclerView recyclerView){
        if (recyclerView==null)return null;
        Context context=recyclerView.getContext();
        String resourceTypeName=context.getResources().getResourceTypeName(id);
        if(!resourceTypeName.contains("layout")){
            throw new RuntimeException(context.getResources().getResourceTypeName(id)+" does not a layout,check again");
        }
        FrameLayout frameLayout=new FrameLayout(context);
        carouselView=LayoutInflater.from(context).inflate(id,frameLayout,false);
        notifyDataSetChanged();
        return carouselView;
    }
    public View setNavigationView(@LayoutRes int id,RecyclerView recyclerView) {
        if (recyclerView==null)return null;
        Context context=recyclerView.getContext();
        String resourceTypeName=context.getResources().getResourceTypeName(id);
        if(!resourceTypeName.contains("layout")){
            throw new RuntimeException(context.getResources().getResourceTypeName(id)+" does not a layout,check again");
        }
        FrameLayout frameLayout=new FrameLayout(context);
        navigationView=LayoutInflater.from(context).inflate(id,frameLayout,false);
        notifyDataSetChanged();
        return navigationView;
    }

    public void setHomeHotColumns(List<HomeHotColumn> homeHotColumns) {
        this.homeHotColumns.addAll(homeHotColumns);
        notifyDataSetChanged();
    }

    public void setHomeFaceScoreColumns(List<RoomInfo> homeFaceScoreColumns) {
        this.homeFaceScoreColumns.addAll(homeFaceScoreColumns);
        notifyDataSetChanged();
    }

    public void setData(List<Category> categories,List<List<RoomInfo>> data) {
        this.categories.addAll(categories);
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clear(){
        carouselView=null;
        navigationView=null;
        homeHotColumns.clear();
        homeFaceScoreColumns.clear();
        categories.clear();
        data.clear();
    }

    protected class VIEW_TYPE{
        public static final int CAROUSEL=-1;
        public static final int NAVIGATION=-2;
        public static final int HOT=-3;
        public static final int FACE=-4;
        public static final int NORMAL=-5;
    }
}
