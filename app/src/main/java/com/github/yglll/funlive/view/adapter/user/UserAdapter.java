package com.github.yglll.funlive.view.adapter.user;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.github.yglll.funlive.view.ClassifyFragment;
import com.github.yglll.funlive.view.RecommendFragment;
import com.github.yglll.funlive.view.UserFragment;
import com.github.yglll.funlive.view.UserRoomListFragment;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends FragmentStatePagerAdapter{

    private List<Fragment> fragmentList;

    public UserAdapter(FragmentManager fragmentManager,List<Fragment> data){
        super(fragmentManager);
        fragmentList=data;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
