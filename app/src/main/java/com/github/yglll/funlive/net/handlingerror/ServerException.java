package com.github.yglll.funlive.net.handlingerror;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/02/16   22:27
 **/
public class ServerException extends RuntimeException {
    public int code;
    public String message;
}
