package com.github.yglll.funlive.view.adapter.recommend;

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
import com.github.yglll.funlive.net.bean.Category;
import com.github.yglll.funlive.view.CateActivity;
import com.github.yglll.funlive.view.EventBus.SelectPageViewEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：YGL
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

    //todo 优化性能
    @Override
    public View getView(int i, View view,ViewGroup viewGroup) {
        final Context context=viewGroup.getContext();
        View mView= LayoutInflater.from(context).inflate(R.layout.item_category,viewGroup,false);
        SimpleDraweeView simpleDraweeView=mView.findViewById(R.id.img_item_gridview);
        TextView name=mView.findViewById(R.id.category_name);
        if(data.size()>0){
            if(i>=7){
                simpleDraweeView.setImageURI(Uri.parse("res://drawable/"+R.drawable.vector_drawable_classify));
                name.setText(context.getText(R.string.more));
                simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SelectPageViewEvent selectPageViewEvent=new SelectPageViewEvent();
                        selectPageViewEvent.setPageNum(1);
                        EventBus.getDefault().post(selectPageViewEvent);
                    }
                });
            }else {
                final Category category=data.get(i);
                simpleDraweeView.setImageURI(Uri.parse(category.getGame_icon()));
                name.setText(category.getGame_name());
                simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CateActivity.startActivity(context,CapiCategory.valueOf(category));
                    }
                });
            }
        }
        return mView;
    }

    public void setData(List<Category> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
