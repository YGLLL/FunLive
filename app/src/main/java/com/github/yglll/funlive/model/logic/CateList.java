package com.github.yglll.funlive.model.logic;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/04   12:17
 **/
public class CateList {
    private String cate_id;
    private String cate_name;
    private String short_name;
    private String push_ios;
    private String push_show;
    private String push_vertical_screen;
    private String push_nearby;

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getPush_ios() {
        return push_ios;
    }

    public void setPush_ios(String push_ios) {
        this.push_ios = push_ios;
    }

    public String getPush_show() {
        return push_show;
    }

    public void setPush_show(String push_show) {
        this.push_show = push_show;
    }

    public String getPush_vertical_screen() {
        return push_vertical_screen;
    }

    public void setPush_vertical_screen(String push_vertical_screen) {
        this.push_vertical_screen = push_vertical_screen;
    }

    public String getPush_nearby() {
        return push_nearby;
    }

    public void setPush_nearby(String push_nearby) {
        this.push_nearby = push_nearby;
    }

    @Override
    public String toString() {
        return "CateList{" +
                "cate_id='" + cate_id + '\'' +
                ", cate_name='" + cate_name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", push_ios='" + push_ios + '\'' +
                ", push_show='" + push_show + '\'' +
                ", push_vertical_screen='" + push_vertical_screen + '\'' +
                ", push_nearby='" + push_nearby + '\'' +
                '}';
    }
}
