package com.github.yglll.funlive.view.adapter.classify;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.net.bean.CapiCategory;
import com.github.yglll.funlive.view.CateActivity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/03   19:01
 **/
public class ClassifyGridAdapter extends BaseAdapter {

    private List<CapiCategory> data;

    public ClassifyGridAdapter(){
        data=new ArrayList<>();
    }
    public ClassifyGridAdapter(List<CapiCategory> list){
        data=list;
        Logger.i("ClassifyGridAdapter data.size():"+data.size());
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        final Context mContext=viewGroup.getContext();
        final CapiCategory capiCategory=data.get(i);
        View mView= LayoutInflater.from(mContext).inflate(R.layout.item_category,viewGroup,false);
        SimpleDraweeView simpleDraweeView=mView.findViewById(R.id.img_item_gridview);
        TextView name=mView.findViewById(R.id.category_name);
        simpleDraweeView.setImageURI(Uri.parse(capiCategory.getIcon_url()));
        simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, CateActivity.class);
                intent.putExtra("cate",capiCategory);
                mContext.startActivity(intent);
            }
        });
        name.setText(capiCategory.getTag_name());
        return mView;
    }

    public void setData(List<CapiCategory> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
