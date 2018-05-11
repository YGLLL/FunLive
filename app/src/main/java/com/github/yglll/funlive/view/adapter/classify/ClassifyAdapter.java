package com.github.yglll.funlive.view.adapter.classify;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.yglll.funlive.net.bean.CateList;
import com.github.yglll.funlive.view.ClassifyGridFragment;

import java.util.ArrayList;
import java.util.List;


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
        ClassifyGridFragment classifyGridFragment =new ClassifyGridFragment();
        classifyGridFragment.setArguments(bundle);
        return classifyGridFragment;
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