package com.github.yglll.funlive.view.adapter.recommend;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.HomeFaceScoreColumn;
import com.github.yglll.funlive.net.bean.RoomInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/25   15:52
 **/
public class FaceScoreColumnAdapter extends RecyclerView.Adapter<FaceScoreColumnAdapter.FaceScoreColumnHolder> {
    private List<RoomInfo> mHomeFaceScoreColumn;

    public FaceScoreColumnAdapter() {
        this.mHomeFaceScoreColumn = new ArrayList<>();
    }

    public void setFaceScoreColumn(List<RoomInfo> mHomeFaceScoreColumn) {
        this.mHomeFaceScoreColumn.clear();
        this.mHomeFaceScoreColumn.addAll(mHomeFaceScoreColumn);
        notifyDataSetChanged();
    }

    public void setFaceScoreColumnLoadMore(List<RoomInfo> mHomeFaceScoreColumn) {
        this.mHomeFaceScoreColumn.addAll(mHomeFaceScoreColumn);
        notifyDataSetChanged();
    }

    @Override
    public FaceScoreColumnHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_info_facescore, parent, false);
        return new FaceScoreColumnHolder(view);
    }

    @Override
    public void onBindViewHolder(FaceScoreColumnHolder holder, int position) {
        holder.img_item_gridview.setImageURI(Uri.parse(mHomeFaceScoreColumn.get(position).getRoom_src()));
        holder.tv_column_item_nickname.setText(mHomeFaceScoreColumn.get(position).getNickname());
        holder.tv_online_num.setText(String.valueOf(mHomeFaceScoreColumn.get(position).getOnline()));

        holder.img_item_gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent(context, PhoneLiveVideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Room_id", mHomeFaceScoreColumn.get(position).getRoom_id());
                bundle.putString("Img_Path", mHomeFaceScoreColumn.get(position).getVertical_src());
                intent.putExtras(bundle);
                context.startActivity(intent);
                */
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHomeFaceScoreColumn.size();
    }

    public class FaceScoreColumnHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView img_item_gridview;
        public TextView tv_column_item_nickname;
        public TextView tv_online_num;

        public FaceScoreColumnHolder(View view) {
            super(view);
            img_item_gridview = (SimpleDraweeView) view.findViewById(R.id.img_item_gridview);
            tv_column_item_nickname = (TextView) view.findViewById(R.id.tv_nickname);
            tv_online_num = (TextView) view.findViewById(R.id.tv_online_num);
        }
    }
}