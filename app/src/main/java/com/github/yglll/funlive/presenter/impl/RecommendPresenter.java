package com.github.yglll.funlive.presenter.impl;

import android.util.Log;

import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.presenter.interfaces.RecommendPresenterInterfaces;

import java.util.List;

import rx.Observer;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public class RecommendPresenter extends RecommendPresenterInterfaces.Presenter{
    private static final String TAG = "RecommendPresenter";
    @Override
    public void setString() {
        /*
        Map<String,Integer> map=new LinkedHashMap<>();
        map.put("offset",0);
        map.put("limit",1);
        model.getCarousel().subscribe(new Observer<HttpResponse<List<HomeCarousel>>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"public void onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"public void onError(Throwable e)");
            }

            @Override
            public void onNext(HttpResponse<List<HomeCarousel>> httpResponse) {
                List<HomeCarousel> list=httpResponse.getData();

            }
        });
        */
    }

    @Override
    public void setCarousel() {
        Log.i("xiancheng","id:"+android.os.Process.myTid());
        mModel.getCarousel().subscribe(new Observer<List<HomeCarousel>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"public void onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"public void onError(Throwable e)");
            }

            @Override
            public void onNext(List<HomeCarousel> list) {
                Log.i("xiancheng","id:"+android.os.Process.myTid());
                String value="";
                for (HomeCarousel homeCarousel:list){
                    value=value+"\n"+homeCarousel.getPic_url();
                }
                mView.showString(value);
                mView.showCarousel(list);
            }
        });
    }
}
