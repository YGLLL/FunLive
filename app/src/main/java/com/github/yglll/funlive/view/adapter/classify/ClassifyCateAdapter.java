package com.github.yglll.funlive.view.adapter.classify;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.view.VideoPlayer;

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

    public ClassifyCateAdapter(Context context){
        mContxt=context;
        isFaceScoreColumn=false;
        roomInfos=new ArrayList<>();
    }
    public ClassifyCateAdapter(Context context,Boolean bool){
        mContxt=context;
        roomInfos=new ArrayList<>();
        isFaceScoreColumn=bool;
    }
    public ClassifyCateAdapter(Context context,List<RoomInfo> list) {
        mContxt=context;
        isFaceScoreColumn=false;
        roomInfos=list;
    }
    public ClassifyCateAdapter(Context context,List<RoomInfo> list,Boolean bool) {
        mContxt=context;
        roomInfos=list;
        isFaceScoreColumn=bool;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_info,parent,false));
    }
    @Override
    public void onBindViewHolder(Holder holder,final int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(roomInfos.get(position).getRoom_src()));
        holder.tv_column_item_nickname.setText(roomInfos.get(position).getRoom_name());
        holder.tv_nickname.setText(roomInfos.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(roomInfos.get(position).getOnline()));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //震动
                Vibrator vibrator=(Vibrator)mContxt.getSystemService(Service.VIBRATOR_SERVICE);
                vibrator.vibrate(200);
                //显示itemControl

                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContxt, VideoPlayer.class);
                intent.putExtra("roomInfo",roomInfos.get(position));
                if(isFaceScoreColumn) {
                    //颜值栏目 竖屏播放
                    intent.putExtra("screenMode",true);
                    mContxt.startActivity(intent);
                }else {
                    mContxt.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomInfos.size();
    }

    public void setData(List<RoomInfo> roomInfos) {
        this.roomInfos = roomInfos;
        notifyDataSetChanged();
    }

    public void setLoadMoreData(List<RoomInfo> roomInfos){
        this.roomInfos.addAll(roomInfos);
        notifyDataSetChanged();
    }
}
