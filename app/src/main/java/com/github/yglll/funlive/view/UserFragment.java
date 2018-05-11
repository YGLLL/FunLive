package com.github.yglll.funlive.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.SigninUserManager;
import com.github.yglll.funlive.application.FLApplication;
import com.github.yglll.funlive.db.FunLiveDbHelper;
import com.github.yglll.funlive.view.adapter.user.UserAdapter;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserFragment extends Fragment{

    @BindView(R.id.bnv)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    private UserAdapter userAdapter;
    private MenuItem menuItem;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        View view=layoutInflater.inflate(R.layout.fragment_user,viewGroup,false);
        ButterKnife.bind(this,view);
        onInitView(bundle);
        return view;
    }

    private void onInitView(Bundle bundle){
        //大坑，要使用getChildFragmentManager()
        userAdapter=new UserAdapter(getChildFragmentManager(),getFragments());
        viewPager.setOffscreenPageLimit(userAdapter.getCount());
        viewPager.setAdapter(userAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=0;
                switch (item.getItemId()){
                    case R.id.follow:
                        i=0;
                        break;
                    case R.id.history:
                        i=1;
                        break;
                }
                if(i!=viewPager.getCurrentItem()){
                    viewPager.setCurrentItem(i);
                }
                return true;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //删除此项
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SigninUserManager.userLogout(getActivity());
                                startActivity(new Intent(getActivity(),SigninActivity.class));
                                getActivity().finish();
                            }
                        })
                        .setMessage("确认退出登录？").create();
                dialog.show();
            }
        });
    }

    private List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(UserRoomListFragment.getInstance(FunLiveDbHelper.collection));
        fragments.add(UserRoomListFragment.getInstance(FunLiveDbHelper.history));
        return fragments;
    }

    @Override
    public void onResume(){
        super.onResume();
        //google analytics
        FLApplication application = (FLApplication) getActivity().getApplication();
        Tracker mTracker = application.getDefaultTracker();

        mTracker.setScreenName(UserFragment.class.toString());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
