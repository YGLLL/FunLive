package com.github.yglll.funlive.view.adapter.recommend;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.FunLiveRoom;
import com.github.yglll.funlive.net.bean.HomeHotColumn;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.view.VideoPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：推荐页“最热”类别适配器，使用的是旧API,返回的是HomeHotColumn
 * 而不是RoomInfo，需要专用的适配器
 * 备注消息：
 * 创建时间：2018/02/26   0:11
 **/
public class HomeHotColumnAdapter extends RecyclerView.Adapter<HomeHotColumnAdapter.Holder>{
    private List<HomeHotColumn> data;
    private Context mContxt;

    public class Holder extends RecyclerView.ViewHolder {
        //        图片
        public SimpleDraweeView img_item_gridview;
        //        房间名称
        public TextView tv_column_item_nickname;
        //        在线人数
        public TextView tv_online_num;
        //        昵称
        public TextView tv_nickname;

        public Holder(View view) {
            super(view);
            img_item_gridview=(SimpleDraweeView)view.findViewById(R.id.img_item_gridview);
            tv_column_item_nickname=(TextView)view.findViewById(R.id.tv_column_item_nickname);
            tv_online_num=(TextView)view.findViewById(R.id.tv_online_num);
            tv_nickname=(TextView)view.findViewById(R.id.tv_nickname);
        }
    }

    public HomeHotColumnAdapter(Context context){
        mContxt=context;
        data=new ArrayList<>();
    }
    public HomeHotColumnAdapter(Context context, List<HomeHotColumn> list) {
        mContxt=context;
        data=new ArrayList<>();
        data.addAll(list);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_info,parent,false));
    }
    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(data.get(position).getRoom_src()));
        holder.tv_column_item_nickname.setText(data.get(position).getRoom_name());
        holder.tv_nickname.setText(data.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(data.get(position).getOnline()));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FunLiveRoom funLiveRoom=FunLiveRoom.valueOf(data.get(position));
                VideoPlayer.startActivity(mContxt,funLiveRoom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<HomeHotColumn> roomInfos) {
        this.data.addAll(roomInfos);
        notifyDataSetChanged();
    }
}
