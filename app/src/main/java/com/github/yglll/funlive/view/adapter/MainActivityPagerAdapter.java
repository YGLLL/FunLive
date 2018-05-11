package com.github.yglll.funlive.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.yglll.funlive.view.ClassifyFragment;
import com.github.yglll.funlive.view.RecommendFragment;
import com.github.yglll.funlive.view.UserFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    public MainActivityPagerAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        this.fragments=data;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
