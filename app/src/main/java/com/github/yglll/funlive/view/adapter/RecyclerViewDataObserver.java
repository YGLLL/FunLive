package com.github.yglll.funlive.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：弃用
 * 创建时间：2018/01/26   21:52
 **/
public class RecyclerViewDataObserver extends RecyclerView.AdapterDataObserver {
    private BaseRecyclerAdapter mAdapter;
    private View view;
    private boolean mAttached;
    private boolean hasData = true;

    public RecyclerViewDataObserver() {

    }

    public void setData(BaseRecyclerAdapter adapter, View view) {
        mAdapter = adapter;
        this.view = view;
//        onChanged();
    }

    @Override
    public void onChanged() {
        if (mAdapter == null) {
            return;
        }
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
        onChanged();
    }

    @Override
    public void onItemRangeChanged(int positionStart, int itemCount) {
        onChanged();
    }

    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
        onChanged();
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
        onChanged();
    }

    @Override
    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        onChanged();
    }


    public void attach() {
        mAttached = true;
    }

    public boolean hasAttached() {
        return mAttached;
    }
}
