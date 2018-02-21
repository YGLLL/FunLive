package com.github.yglll.funlive.view.adapter.classify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.view.ClassifyChildrenFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：使用了FragmentStatePagerAdapter，可以在切换Fragment时不销毁Fragment
 * 创建时间：2018/02/04   11:04
 **/
public class ClassifyAdapter extends FragmentStatePagerAdapter {
    public static final String CATENAMEKEY="cateName";

    private List<CateList> data;

    public ClassifyAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        data=new ArrayList<>();
    }
    public ClassifyAdapter(FragmentManager fragmentManager, List<CateList> list){
        super(fragmentManager);
        data=list;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        bundle.putString(CATENAMEKEY,data.get(position).getShort_name());
        ClassifyChildrenFragment classifyChildrenFragment=new ClassifyChildrenFragment();
        classifyChildrenFragment.setArguments(bundle);
        return classifyChildrenFragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    public void setData(List<CateList> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}