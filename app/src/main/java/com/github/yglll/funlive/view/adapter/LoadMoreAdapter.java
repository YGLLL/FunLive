package com.github.yglll.funlive.view.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.lang.reflect.Type;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/13   0:25
 **/
public abstract class LoadMoreAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {

    private View loadMoreView;
    private final static int LOADMORE=-1;
    private final static int NORMAL=-2;
    private Context mContext;

    public LoadMoreAdapter(Context context){
        mContext=context;
    }

    class LoadMoreViewHolder extends RecyclerView.ViewHolder{
        public LoadMoreViewHolder(View view){
            super(view);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==LOADMORE){
            return new LoadMoreViewHolder(loadMoreView);
        }
        if(viewType==NORMAL){
            return onCreateNormalViewHolder(parent, viewType);
        }
        return null;
    }
    public abstract T onCreateNormalViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(!((position + 1 == getItemCount())&&existLoadMoreView()>0)){
            onBindNormalViewHolder((T)holder, position);
        }
    }
    public abstract void onBindNormalViewHolder(T holder, int position);

    @Override
    public int getItemCount() {
        return getNormalItemCount()+existLoadMoreView();
    }
    public abstract int getNormalItemCount();

    @Override
    public int getItemViewType(int position) {
        if ((position + 1 == getItemCount())&&existLoadMoreView()>0) {
            return LOADMORE;
        } else {
            return NORMAL;
        }
    }

    public View setLoadMoreView(@LayoutRes int id){
        String resourceTypeName=mContext.getResources().getResourceTypeName(id);
        if(!resourceTypeName.contains("layout")){
            throw new RuntimeException(mContext.getResources().getResourceTypeName(id)+" does not a layout,check again");
        }
        FrameLayout frameLayout=new FrameLayout(mContext);
        loadMoreView= LayoutInflater.from(mContext).inflate(id,frameLayout,false);
        notifyDataSetChanged();
        return loadMoreView;
    }
    private int existLoadMoreView(){
        return loadMoreView==null?0:1;
    }
}
