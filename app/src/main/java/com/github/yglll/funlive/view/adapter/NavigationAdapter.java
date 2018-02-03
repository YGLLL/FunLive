package com.github.yglll.funlive.view.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.logic.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/02   13:32
 **/
public class NavigationAdapter extends BaseAdapter {
    private List<Category> data;

    public NavigationAdapter(){
        data=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return 8;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category,viewGroup,false);
        SimpleDraweeView simpleDraweeView=mView.findViewById(R.id.img_item_gridview);
        TextView name=mView.findViewById(R.id.category_name);
        if(data.size()>0){
            if(i==7){
                simpleDraweeView.setImageURI(Uri.parse("res://mipmap/"+R.mipmap.ic_launcher));
                name.setText(viewGroup.getContext().getText(R.string.more));
            }else {
                simpleDraweeView.setImageURI(Uri.parse(data.get(i).getGame_icon()));
                name.setText(data.get(i).getGame_name());
            }
        }
        return mView;
    }

    public void setData(List<Category> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
