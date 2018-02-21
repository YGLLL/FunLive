package com.github.yglll.funlive.view.EventBus;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：一个消息，发送到MainActivity，以选择Fragment
 * 创建时间：2018/02/10   14:20
 **/
public class SelectPageViewEvent {
    private int pageNum;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
