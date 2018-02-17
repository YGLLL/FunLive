package com.github.yglll.funlive.danmu.utils;

import com.github.yglll.funlive.danmu.client.DyBulletScreenClient;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/17
 **/
public class KeepAlive extends Thread {
    @Override
    public void run()
    {
        //获取弹幕客户端
        DyBulletScreenClient danmuClient = DyBulletScreenClient.getInstance();

        //判断客户端就绪状态
        while(danmuClient.getReadyFlag())
        {
            //发送心跳保持协议给服务器端
            danmuClient.keepAlive();
            try
            {
                //设置间隔5秒再发送心跳协议
                Thread.sleep(5000);        //keep live at least once per minute
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
