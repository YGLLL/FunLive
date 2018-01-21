package com.github.yglll.funlive.view.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.logic.HomeHotColumn;
import com.github.yglll.funlive.utils.Utils;

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
    private List<String> list;
    private List<HomeHotColumn> homeHotColumns;

    protected View customHeaderView=null;
    protected View customLoadMoreView=null;
    protected View classifyView=null;

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

    public RecommendAdapter(List<String> list){
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE.HEADER:
                return new CustomViewHolder(customHeaderView);
            case VIEW_TYPE.CLASSIFY:
                break;
            case VIEW_TYPE.FOOTER:
                break;
            case VIEW_TYPE.NORMAL:
                TextView textView=new TextView(parent.getContext());
                return new ViewHolder(textView);
        }
        TextView textView=new TextView(parent.getContext());
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isHaveHeader()>0){
            if(position>=1){
                ((ViewHolder)holder).textView.append(list.get(--position));
            }
        }else {
            ((ViewHolder)holder).textView.append(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+isHaveHeader()+isHaveClassify()+isHaveFooter();
    }

    @Override
    public final int getItemViewType(int position){
        switch (position){
            case 0:
                if(isHaveHeader()>0)return VIEW_TYPE.HEADER;
                break;
            case 1:
                if(isHaveClassify()>0)return VIEW_TYPE.CLASSIFY;
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
    }

    protected class VIEW_TYPE{
        public static final int HEADER=-1;
        public static final int FOOTER=-2;
        public static final int NORMAL=-3;
        public static final int CLASSIFY=-4;
    }
}
