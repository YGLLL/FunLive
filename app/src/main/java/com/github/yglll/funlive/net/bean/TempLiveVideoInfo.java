package com.github.yglll.funlive.net.bean;


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
