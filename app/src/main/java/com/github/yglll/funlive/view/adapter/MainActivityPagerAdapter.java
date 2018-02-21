package com.github.yglll.funlive.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.yglll.funlive.view.ClassifyFragment;
import com.github.yglll.funlive.view.RecommendFragment;
import com.github.yglll.funlive.view.UserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/20   23:28
 **/
public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    public MainActivityPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments=getFragments();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    //添加三大Fragment
    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new UserFragment());
        return fragments;
    }
}
