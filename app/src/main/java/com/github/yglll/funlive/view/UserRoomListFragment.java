package com.github.yglll.funlive.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.yglll.funlive.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/20   23:24
 **/
public class UserRoomListFragment extends Fragment {

    @BindView(R.id.refresh_layout)
    SmartRefreshLayout smartRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle){
        View view=layoutInflater.inflate(R.layout.fragment_user_room_list,viewGroup,false);
        ButterKnife.bind(this,view);
        onInitView(bundle);
        return view;
    }

    private void onInitView(Bundle bundle){

    }
}
