package com.github.yglll.funlive.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.VideoPlayerModel;
import com.github.yglll.funlive.model.logic.TempLiveVideoInfo;
import com.github.yglll.funlive.mvpbase.BaseActivity;
import com.github.yglll.funlive.mvpbase.BaseView;
import com.github.yglll.funlive.presenter.impl.VideoPlayerPresenter;
import com.github.yglll.funlive.presenter.interfaces.VideoPlayerInterfaces;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.widget.VideoView;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/20   22:24
 **/
public class VideoPlayer extends BaseActivity<VideoPlayerModel,VideoPlayerPresenter> implements VideoPlayerInterfaces.View {

    @BindView(R.id.vm_videoview)
    VideoView vmVideoview;

    @Override
    public void initView(Bundle bundle) {

    }

    @Override
    public void onStart(){
        super.onStart();
        int roomId=getIntent().getIntExtra("roomId",-1);
        mPresenter.setVideoUrl(roomId);
    }

    @Override
    public String activityTitle() {
        return "视频播放器";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void acquisitionVideoUrl(String url) {
        Logger.i(url);
        Uri uri = Uri.parse(url);
        if (vmVideoview != null) {
            vmVideoview.setVideoURI(uri);
            vmVideoview.setBufferSize(1024 * 1024 * 2);
            vmVideoview.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
            vmVideoview.requestFocus();
            //vmVideoview.setSubShown(true);

            vmVideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    // optional need Vitamio 4.0
                    mediaPlayer.setPlaybackSpeed(1.0f);
                    vmVideoview.start();

                }
            });
        }
    }
}
