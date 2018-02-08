package com.github.yglll.funlive.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.logic.HomeHotColumn;
import com.github.yglll.funlive.model.logic.RoomInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/08   23:17
 **/
public class ClassifyCateAdapter extends RecyclerView.Adapter<ClassifyCateAdapter.Holder> {
    private List<RoomInfo> roomInfos;
    private Boolean isFaceScoreColumn;

    public class Holder extends RecyclerView.ViewHolder {
        //        图片
        public SimpleDraweeView img_item_gridview;
        //        房间名称
        public TextView tv_column_item_nickname;
        //        在线人数
        public TextView tv_online_num;
        //        昵称
        public TextView tv_nickname;
        //        Icon
        public RelativeLayout rl_live_icon;

        public Holder(View view) {
            super(view);
            img_item_gridview=(SimpleDraweeView)view.findViewById(R.id.img_item_gridview);
            tv_column_item_nickname=(TextView)view.findViewById(R.id.tv_column_item_nickname);
            tv_online_num=(TextView)view.findViewById(R.id.tv_online_num);
            tv_nickname=(TextView)view.findViewById(R.id.tv_nickname);
            rl_live_icon=(RelativeLayout)view.findViewById(R.id.rl_live_icon);
        }
    }

    public ClassifyCateAdapter(){
        isFaceScoreColumn=false;
        roomInfos=new ArrayList<>();
    }
    public ClassifyCateAdapter(Boolean bool){
        roomInfos=new ArrayList<>();
        isFaceScoreColumn=bool;
    }
    public ClassifyCateAdapter(List<RoomInfo> list) {
        isFaceScoreColumn=false;
        roomInfos=list;
    }
    public ClassifyCateAdapter(List<RoomInfo> list,Boolean bool) {
        roomInfos=list;
        isFaceScoreColumn=bool;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_recommend_view,parent,false));
    }
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(roomInfos.get(position).getRoom_src()));
        holder.tv_column_item_nickname.setText(roomInfos.get(position).getRoom_name());
        holder.tv_nickname.setText(roomInfos.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(roomInfos.get(position).getOnline()));
        if(isFaceScoreColumn) {
            //holder.rl_live_icon.setBackgroundResource(R.drawable.search_header_live_type_mobile);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                //                颜值栏目 竖屏播放
                if(mHomeHotColumn.get(position).getCate_id().equals("201"))
                {
                    Intent intent = new Intent(context, PhoneLiveVideoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Room_id",mHomeHotColumn.get(position).getRoom_id());
                    bundle.putString("Img_Path", mHomeHotColumn.get(position).getVertical_src());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }else {
                    Intent intent = new Intent(context, PcLiveVideoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Room_id", mHomeHotColumn.get(position).getRoom_id());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
                */
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomInfos.size();
    }

    public void setRoomInfos(List<RoomInfo> roomInfos) {
        this.roomInfos = roomInfos;
        notifyDataSetChanged();
    }
}
