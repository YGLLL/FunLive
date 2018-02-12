package com.github.yglll.funlive.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.view.EventBus.SelectPageViewEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.bnve)
    BottomNavigationView mBottomNavigationView;
    private MenuItem menuItem;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentList=getFragments();

        //不摧毁Fragment
        viewPager.setOffscreenPageLimit(fragmentList.size());
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(mInternalPageChangeListener);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=0;
                switch (item.getItemId()){
                    case R.id.recommend:
                        i=0;
                        break;
                    case R.id.classify:
                        i=1;
                        break;
                    case R.id.user:
                        i=2;
                        break;
                }
                if(i!=viewPager.getCurrentItem()){
                    viewPager.setCurrentItem(i);
                }
                return true;
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSelectPage(SelectPageViewEvent event) {
        int i=event.getPageNum();
        if(i!=viewPager.getCurrentItem()){
            viewPager.setCurrentItem(i);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private final ViewPager.OnPageChangeListener mInternalPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (menuItem != null) {
                menuItem.setChecked(false);
            } else {
                mBottomNavigationView.getMenu().getItem(0).setChecked(false);
            }
            menuItem = mBottomNavigationView.getMenu().getItem(position);
            menuItem.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecommendFragement());
        fragments.add(new ClassifyFragment());
        fragments.add(new UserFragment());
        return fragments;
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments=fragments;
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
}
