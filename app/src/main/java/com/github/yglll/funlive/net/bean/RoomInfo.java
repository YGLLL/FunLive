package com.github.yglll.funlive.net.bean;

import java.io.Serializable;


public class RoomInfo{
    /*
    * "room_id": 300401,
      "room_src": "https://rpic.douyucdn.cn/amrpic-180208/300401_2255.jpg",
      "room_name": "全能王拉哥:大家小年夜快乐~",
      "owner_uid": "19489211",
      "online": 55778,
      "hn": 55778,
      "nickname": "全能王拉哥300401",
      "url": "http://www.douyu.com/300401"
      */
    private int room_id;
    private String room_src;
    private String room_name;
    private String owner_uid;
    private int online;
    private int hn;
    private String nickname;
    private String url;

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

    @Override
    public String toString() {
        return "RoomInfo{" +
                "room_id=" + room_id +
                ", room_src='" + room_src + '\'' +
                ", room_name='" + room_name + '\'' +
                ", owner_uid='" + owner_uid + '\'' +
                ", online=" + online +
                ", hn=" + hn +
                ", nickname='" + nickname + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
