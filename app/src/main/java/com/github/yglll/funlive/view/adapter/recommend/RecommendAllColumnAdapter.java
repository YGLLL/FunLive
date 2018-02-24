package com.github.yglll.funlive.view.adapter.recommend;

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
import com.github.yglll.funlive.net.bean.HomeCate;

import java.util.List;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/26   22:55
 **/
public class RecommendAllColumnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeCate.RoomListEntity> mRommListEntity;
    private Context context;

    public RecommendAllColumnAdapter(Context context, List<HomeCate.RoomListEntity> mRommListEntity) {
        this.context=context;
        this.mRommListEntity=mRommListEntity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotColumnHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_info,parent,false));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HotColumnHolder) {
            bindHotColumun((HotColumnHolder) holder,position);
        }
    }
    private void bindHotColumun(HotColumnHolder holder, int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(mRommListEntity.get(position).getVertical_src()));
        holder.tv_column_item_nickname.setText(mRommListEntity.get(position).getRoom_name());
        holder.tv_nickname.setText(mRommListEntity.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(mRommListEntity.get(position).getOnline()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
//                颜值栏目 竖屏播放
                if(mRommListEntity.get(position).getCate_id().equals("201"))
                {
                    Intent intent = new Intent(context, PhoneLiveVideoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Room_id",mRommListEntity.get(position).getRoom_id());
                    bundle.putString("Img_Path", mRommListEntity.get(position).getVertical_src());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }else {
                    Intent intent = new Intent(context, PcLiveVideoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Room_id", mRommListEntity.get(position).getRoom_id());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
                */
            }
        });
    }
    @Override
    public int getItemCount() {
        return mRommListEntity.size();
    }
    public class HotColumnHolder extends RecyclerView.ViewHolder {
        //        图片
        public SimpleDraweeView img_item_gridview;
        //        房间名称
        public TextView tv_column_item_nickname;
        //        在线人数
        public TextView tv_online_num;
        //        昵称
        public TextView tv_nickname;

        public HotColumnHolder(View view) {
            super(view);
            img_item_gridview=(SimpleDraweeView)view.findViewById(R.id.img_item_gridview);
            tv_column_item_nickname=(TextView)view.findViewById(R.id.tv_column_item_nickname);
            tv_online_num=(TextView)view.findViewById(R.id.tv_online_num);
            tv_nickname=(TextView)view.findViewById(R.id.tv_nickname);
        }
    }
}
