package com.github.yglll.funlive.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.github.yglll.funlive.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.utils.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.bnve)
    BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),getFragments());
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(mInternalPageChangeListener);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG,"onNavigationItemSelected");
                //onTabItemSelected(item.getItemId());
                return true;
            }
        });
        // 由于第一次进来没有回调onNavigationItemSelected，因此需要手动调用一下切换状态的方法
        onTabItemSelected(R.id.recommend);
    }

    private final ViewPager.OnPageChangeListener mInternalPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Log.i(TAG,"onPageSelected");
            int id=0;
            switch (position){
                case 0:
                    id=R.id.recommend;
                    break;
                case 1:
                    id=R.id.classify;
                    break;
                case 2:
                    id=R.id.user;
                    break;
            }
            mBottomNavigationView.setSelectedItemId(id);
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

    private void onTabItemSelected(int id){
        switch (id){
            case R.id.recommend:
                viewPager.setCurrentItem(0);
                break;
            case R.id.classify:
                viewPager.setCurrentItem(1);
                break;
            case R.id.user:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    private class MyPagerAdapter extends FragmentPagerAdapter{
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
