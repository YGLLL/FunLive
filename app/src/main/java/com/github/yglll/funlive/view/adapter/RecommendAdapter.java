package com.github.yglll.funlive.view.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.logic.HomeFaceScoreColumn;
import com.github.yglll.funlive.model.logic.HomeHotColumn;
import com.github.yglll.funlive.utils.FullyGridLayoutManager;
import com.github.yglll.funlive.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/18   18:40
 **/
public class RecommendAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RecommendAdapter";
    private List<HomeHotColumn> homeHotColumns;
    private HotColumnAdapter hotColumnAdapter;
    private List<HomeFaceScoreColumn> homeFaceScoreColumns;
    private FaceScoreColumnAdapter faceScoreColumnAdapter;
    private Context mContext;

    protected View customHeaderView=null;
    protected View customLoadMoreView=null;
    protected View classifyView=null;

    public RecommendAdapter(Context context){
        this.mContext=context;
        homeHotColumns=new ArrayList<>();
        homeFaceScoreColumns=new ArrayList<>();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {
        //栏目 Icon
        public ImageView img_column_icon;
        //栏目 名称
        public TextView tv_column_name;
        //加载更多
        public RelativeLayout rl_column_more;
        //栏目列表
        public RecyclerView rv_column_list;

        public LinearLayout item_home_recommed_girdview;

        public NormalViewHolder(View itemView) {
            super(itemView);
            img_column_icon = (ImageView) itemView.findViewById(R.id.img_column_icon);
            tv_column_name = (TextView) itemView.findViewById(R.id.tv_column_name);
            rl_column_more = (RelativeLayout) itemView.findViewById(R.id.rl_column_more);
            rv_column_list = (RecyclerView) itemView.findViewById(R.id.rv_column_list);
            item_home_recommed_girdview = (LinearLayout) itemView.findViewById(R.id.item_home_recommed_girdview);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View view){
            super(view);
            textView =(TextView)view;
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
            case VIEW_TYPE.HEADER:
                return new CustomViewHolder(customHeaderView);
            case VIEW_TYPE.FOOTER:
                break;
            case VIEW_TYPE.NORMAL:
                return new NormalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_recommend, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int start = isHaveHeader();
        if (!isHeader(position) && !isFooter(position)) {
            onBindNormalViewHolder(holder, position - start, true);
        }
    }
    private void onBindNormalViewHolder(RecyclerView.ViewHolder holder, int position,Boolean isItem){
        if(holder instanceof NormalViewHolder){
            NormalViewHolder normalViewHolder=(NormalViewHolder)holder;
            switch (position){
                case 0:
                    normalViewHolder.img_column_icon.setImageResource(R.mipmap.ic_launcher);
                    normalViewHolder.tv_column_name.setText("最热");
                    normalViewHolder.rv_column_list.setLayoutManager(new FullyGridLayoutManager(normalViewHolder.rv_column_list.getContext(), 2, GridLayoutManager.VERTICAL, false));
                    hotColumnAdapter = new HotColumnAdapter(normalViewHolder.rv_column_list.getContext(),homeHotColumns);
                    normalViewHolder.rv_column_list.setAdapter(hotColumnAdapter);
                    break;
                case 1:
                    normalViewHolder.img_column_icon.setImageResource(R.mipmap.ic_launcher);
                    normalViewHolder.tv_column_name.setText("颜值");
                    normalViewHolder.rv_column_list.setLayoutManager(new FullyGridLayoutManager(normalViewHolder.rv_column_list.getContext(), 2, GridLayoutManager.VERTICAL, false));
                    faceScoreColumnAdapter=new FaceScoreColumnAdapter(normalViewHolder.rv_column_list.getContext());
                    faceScoreColumnAdapter.setFaceScoreColumn(homeFaceScoreColumns);
                    normalViewHolder.rv_column_list.setAdapter(faceScoreColumnAdapter);
                    break;
                default:
            }
        }
    }

    public boolean isFooter(int position) {
        int start = isHaveFooter();
        return customLoadMoreView != null && position > getItemCount() + start;
    }

    public boolean isHeader(int position) {
        return isHaveHeader() > 0 && position == 0;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public final int getItemViewType(int position){
        switch (position){
            case 0:
                if(isHaveHeader()>0)return VIEW_TYPE.HEADER;
                break;
            default:
                if(position>=getItemCount()&&isHaveFooter()>0)return VIEW_TYPE.FOOTER;
        }
        return VIEW_TYPE.NORMAL;
    }

    private int isHaveHeader(){
        return customHeaderView==null?0:1;
    }
    private int isHaveClassify(){
        return classifyView==null?0:1;
    }
    private int isHaveFooter(){
        return customLoadMoreView==null?0:1;
    }

    public View setCustomHeaderView(View customHeaderView) {
        Utils.removeViewFromParent(customHeaderView);
        this.customHeaderView = customHeaderView;
        notifyDataSetChanged();
        return customHeaderView;
    }
    public View setCustomHeaderView(@LayoutRes int id,RecyclerView recyclerView){
        if (recyclerView==null)return null;
        Context context=recyclerView.getContext();
        String resourceTypeName=context.getResources().getResourceTypeName(id);
        if(!resourceTypeName.contains("layout")){
            throw new RuntimeException(context.getResources().getResourceTypeName(id)+" does not a layout,check again");
        }
        FrameLayout frameLayout=new FrameLayout(context);
        customHeaderView=LayoutInflater.from(context).inflate(id,frameLayout,false);
        notifyDataSetChanged();
        return customHeaderView;
    }
    public void setCustomLoadMoreView(View customLoadMoreView) {
        this.customLoadMoreView = customLoadMoreView;
    }
    public void setClassifyView(View classifyView) {
        this.classifyView = classifyView;
    }

    public void setHomeHotColumns(List<HomeHotColumn> homeHotColumns) {
        this.homeHotColumns = homeHotColumns;
        notifyDataSetChanged();
    }

    public void setHomeFaceScoreColumns(List<HomeFaceScoreColumn> homeFaceScoreColumns) {
        this.homeFaceScoreColumns = homeFaceScoreColumns;
        notifyDataSetChanged();
    }

    protected class VIEW_TYPE{
        public static final int HEADER=-1;
        public static final int FOOTER=-2;
        public static final int NORMAL=-3;
    }
}
