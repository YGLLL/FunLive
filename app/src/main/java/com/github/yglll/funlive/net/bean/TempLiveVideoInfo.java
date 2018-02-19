package com.github.yglll.funlive.net.bean;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/20   22:27
 **/
public class TempLiveVideoInfo {
    private String hls_url;

    public String getHls_url() {
        return hls_url;
    }

    public void setHls_url(String hls_url) {
        this.hls_url = hls_url;
    }

    @Override
    public String toString() {
        return "TempLiveVideoInfo{" +
                "hls_url='" + hls_url + '\'' +
                '}';
    }
}
