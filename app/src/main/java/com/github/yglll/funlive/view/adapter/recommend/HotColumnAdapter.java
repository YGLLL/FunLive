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
import com.github.yglll.funlive.net.bean.HomeHotColumn;

import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/21   22:36
 **/
public class HotColumnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeHotColumn> mHomeHotColumn;
    private Context context;

    public HotColumnAdapter(Context context, List<HomeHotColumn> mHomeHotColumn)
    {
        this.context=context;
        this.mHomeHotColumn=mHomeHotColumn;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotColumnHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_info,parent,false));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HotColumnHolder)
        {
            bindHotColumun((HotColumnHolder) holder,position);
        }
    }
    private void bindHotColumun(HotColumnHolder holder,final int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(mHomeHotColumn.get(position).getVertical_src()));
        holder.tv_column_item_nickname.setText(mHomeHotColumn.get(position).getRoom_name());
        holder.tv_nickname.setText(mHomeHotColumn.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(mHomeHotColumn.get(position).getOnline()));
        if(mHomeHotColumn.get(position).getCate_id().equals("201"))
        {
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
        return mHomeHotColumn.size();
    }
    public class HotColumnHolder extends RecyclerView.ViewHolder
    {
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