package com.github.yglll.funlive.view.adapter.recommend;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

import cn.bingoogolapple.bgabanner.BGABanner;

public class CarouselAdapter implements BGABanner.Adapter<SimpleDraweeView, String> {
    @Override
    public void fillBannerItem(BGABanner banner, SimpleDraweeView itemView, String model, int position) {
        itemView.setImageURI(Uri.parse(model));
    }
}
