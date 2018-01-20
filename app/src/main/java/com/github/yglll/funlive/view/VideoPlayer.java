package com.github.yglll.funlive.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.yglll.funlive.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.utils.Log;
import io.vov.vitamio.widget.VideoView;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/20   22:24
 **/
public class VideoPlayer extends AppCompatActivity {
    private static final String TAG = "VideoPlayer";
    @BindView(R.id.vm_videoview)
    VideoView vmVideoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        ButterKnife.bind(this);
        //String url="http://ips.ifeng.com/video02.ifeng.com/video04/2011/03/24/480x360_offline20110324.mp4";
        String url=getIntent().getStringExtra("URL");
        Log.i(TAG,"URL:"+url);
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
