package com.github.yglll.funlive.net.bean;

import java.io.Serializable;

/**
 * 作者：YGL
 * 版本号：1.0
 * 类描述：斗鱼API中的房间信息(com.github.yglll.funlive.net.bean.RoomInfo)中，
 * 并没有信息表明视频该横屏播放还是竖屏播放
 * 此类在RoomInfo基础上，加入该信息，以指导视频播放器该如何播放
 * 备注消息：
 * 创建时间：2018/02/24   18:40
 **/
public class FunLiveRoom implements Serializable {

    private int room_id;
    private String room_src;
    private String room_name;
    private String owner_uid;
    private int online;
    private int hn;
    private String nickname;
    private String url;
    private Boolean vertical;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_src() {
        return room_src;
    }

    public void setRoom_src(String room_src) {
        this.room_src = room_src;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getOwner_uid() {
        return owner_uid;
    }

    public void setOwner_uid(String owner_uid) {
        this.owner_uid = owner_uid;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getHn() {
        return hn;
    }

    public void setHn(int hn) {
        this.hn = hn;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getVertical() {
        return vertical;
    }

    public void setVertical(Boolean vertical) {
        this.vertical = vertical;
    }

    @Override
    public String toString() {
        return "FunLiveRoom{" +
                "room_id=" + room_id +
                ", room_src='" + room_src + '\'' +
                ", room_name='" + room_name + '\'' +
                ", owner_uid='" + owner_uid + '\'' +
                ", online=" + online +
                ", hn=" + hn +
                ", nickname='" + nickname + '\'' +
                ", url='" + url + '\'' +
                ", vertical=" + vertical +
                '}';
    }

    public static FunLiveRoom valueOf(RoomInfo theRoom, Boolean vertical){
        FunLiveRoom funLiveRoom=new FunLiveRoom();
        funLiveRoom.setRoom_id(theRoom.getRoom_id());
        funLiveRoom.setRoom_src(theRoom.getRoom_src());
        funLiveRoom.setRoom_name(theRoom.getRoom_name());
        funLiveRoom.setOwner_uid(theRoom.getOwner_uid());
        funLiveRoom.setOnline(theRoom.getOnline());
        funLiveRoom.setHn(theRoom.getOnline());
        funLiveRoom.setNickname(theRoom.getNickname());
        funLiveRoom.setUrl(theRoom.getUrl());
        funLiveRoom.setVertical(vertical);
        return funLiveRoom;
    }

    public static FunLiveRoom valueOf(HomeCarousel.TheRoom theRoom){
        FunLiveRoom funLiveRoom=new FunLiveRoom();
        funLiveRoom.setRoom_id(theRoom.getRoom_id());
        funLiveRoom.setRoom_src(theRoom.getRoom_src());
        funLiveRoom.setRoom_name(theRoom.getRoom_name());
        funLiveRoom.setOwner_uid(theRoom.getOwner_uid());
        funLiveRoom.setOnline(theRoom.getOnline());
        funLiveRoom.setHn(theRoom.getOnline());
        funLiveRoom.setNickname(theRoom.getNickname());
        funLiveRoom.setUrl("http://www.douyu.com"+theRoom.getUrl());
        if(theRoom.getCate_id().equals("201")){
            funLiveRoom.setVertical(true);
        }else {
            funLiveRoom.setVertical(false);
        }
        return funLiveRoom;
    }

    public static FunLiveRoom valueOf(HomeHotColumn theRoom){
        FunLiveRoom funLiveRoom=new FunLiveRoom();
        funLiveRoom.setRoom_id(Integer.valueOf(theRoom.getRoom_id()));
        funLiveRoom.setRoom_src(theRoom.getRoom_src());
        funLiveRoom.setRoom_name(theRoom.getRoom_name());
        funLiveRoom.setOwner_uid("none");
        funLiveRoom.setOnline(theRoom.getOnline());
        funLiveRoom.setHn(theRoom.getOnline());
        funLiveRoom.setNickname(theRoom.getNickname());
        funLiveRoom.setUrl("http://www.douyu.com"+theRoom.getRoom_id());
        if(theRoom.getCate_id().equals("201")){
            funLiveRoom.setVertical(true);
        }else {
            funLiveRoom.setVertical(false);
        }
        return funLiveRoom;
    }
}
