package com.github.yglll.funlive.view.adapter;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/31   20:39
 **/
public class HomeCarouselAdapter implements BGABanner.Adapter<SimpleDraweeView, String> {
    @Override
    public void fillBannerItem(BGABanner banner, SimpleDraweeView itemView, String model, int position) {
        itemView.setImageURI(Uri.parse(model));
    }
}
