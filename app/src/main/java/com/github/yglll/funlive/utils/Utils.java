package com.github.yglll.funlive.utils;

import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/19   16:17
 **/
public class Utils {
    public static void removeViewFromParent(View view){
        if (view==null)return;
        ViewGroup parent=(ViewGroup)view.getParent();
        if (parent!=null) parent.removeView(view);
    }
}
