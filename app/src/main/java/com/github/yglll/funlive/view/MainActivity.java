package com.github.yglll.funlive.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.yglll.funlive.DataGenerator;
import com.github.yglll.funlive.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    private Fragment[]mFragments;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments = DataGenerator.getFragments("BottomNavigationView Tab");

        initView();
    }

    private void initView() {
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bnve);
        //mBottomNavigationView.getMaxItemCount()

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onTabItemSelected(item.getItemId());
                return true;
            }
        });

        // 由于第一次进来没有回调onNavigationItemSelected，因此需要手动调用一下切换状态的方法
        onTabItemSelected(R.id.recommend);
    }

    private void onTabItemSelected(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.recommend:
                fragment = mFragments[0];
                break;
            case R.id.classify:
                fragment = mFragments[1];
                break;
            case R.id.user:
                fragment = mFragments[2];
                break;
        }
        if(fragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
        }
    }
}
