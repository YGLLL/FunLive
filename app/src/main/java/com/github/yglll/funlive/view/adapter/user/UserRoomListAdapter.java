package com.github.yglll.funlive.view.adapter.user;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.db.FunLiveDB;
import com.github.yglll.funlive.db.FunLiveDbHelper;
import com.github.yglll.funlive.db.FunLiveProvide;
import com.github.yglll.funlive.net.bean.FunLiveRoom;
import com.github.yglll.funlive.net.bean.RoomInfo;
import com.github.yglll.funlive.view.VideoPlayer;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/24   20:07
 **/
public class UserRoomListAdapter extends RecyclerView.Adapter<UserRoomListAdapter.Holder> {
    private List<FunLiveRoom> funLiveRoomList;
    private Context mContxt;
    private FunLiveDB funLiveDB;
    private final String tabName;

    public class Holder extends RecyclerView.ViewHolder {
        //        图片
        public SimpleDraweeView img_item_gridview;
        //        房间名称
        public TextView tv_column_item_nickname;
        //        在线人数
        public TextView tv_online_num;
        //        昵称
        public TextView tv_nickname;
        //删除
        public ImageView delete;

        public Holder(View view) {
            super(view);
            img_item_gridview=(SimpleDraweeView)view.findViewById(R.id.img_item_gridview);
            tv_column_item_nickname=(TextView)view.findViewById(R.id.tv_column_item_nickname);
            tv_online_num=(TextView)view.findViewById(R.id.tv_online_num);
            tv_nickname=(TextView)view.findViewById(R.id.tv_nickname);
            delete=(ImageView)view.findViewById(R.id.delete);
        }
    }

    public UserRoomListAdapter(Context context, FunLiveDB funLiveDB,String tabName){
        mContxt=context;
        funLiveRoomList=new ArrayList<>();
        this.funLiveDB=funLiveDB;
        this.tabName=tabName;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_info_user,parent,false));
    }
    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(funLiveRoomList.get(position).getRoom_src()));
        holder.tv_column_item_nickname.setText(funLiveRoomList.get(position).getRoom_name());
        holder.tv_nickname.setText(funLiveRoomList.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(funLiveRoomList.get(position).getOnline()));
        /*
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
        */
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //删除此项
                AlertDialog dialog = new AlertDialog.Builder(mContxt)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                funLiveDB.deleteRoomFromId(funLiveRoomList.get(position).getId(),tabName);
                                //无法回调onLoadFinished
                                //Uri uri=Uri.parse(FunLiveProvide.CONTENTAGREEMENT+FunLiveProvide.AUTHORITIES+FunLiveProvide.DELETE+tabName);
                                //mContxt.getContentResolver().delete(uri,"id=?",new String[]{String.valueOf(funLiveRoomList.get(position).getId())});
                                Logger.i("AlertDialog:");
                                //刷新数据
                                //无法回调onLoadFinished
                                setData(getData());
                            }
                        })
                        .setMessage("确认删除？").create();
                dialog.show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FunLiveRoom funLiveRoom=funLiveRoomList.get(position);
                VideoPlayer.startActivity(mContxt,funLiveRoom);
            }
        });
    }

    @Override
    public int getItemCount() {
        return funLiveRoomList.size();
    }

    public void setData(List<FunLiveRoom> data) {
        this.funLiveRoomList.clear();
        this.funLiveRoomList.addAll(data);
        notifyDataSetChanged();
    }

    public void setLoadMoreData(List<FunLiveRoom> data){
        this.funLiveRoomList.addAll(data);
        notifyDataSetChanged();
    }

    private List<FunLiveRoom> getData(){
        List<FunLiveRoom> list=funLiveDB.getAllFunLiveRoom(tabName);
        Logger.i("list.size()"+list.size());
        //反转排序
        Collections.reverse(list);
        return list;
    }
}
