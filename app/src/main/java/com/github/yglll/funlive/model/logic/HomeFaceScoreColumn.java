package com.github.yglll.funlive.model.logic;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/25   15:35
 **/
public class HomeFaceScoreColumn {
    private String room_id;
    private String room_src;
    private String vertical_src;
    private int isVertical;
    private String cate_id;
    private String room_name;
    private String show_status;
    private String subject;
    private String show_time;
    private String owner_uid;
    private String specific_catalog;
    private String specific_status;
    private String vod_quality;
    private String nickname;
    private int online;
    private String game_name;
    private String child_id;
    private String avatar_mid;
    private String avatar_small;
    private String jumpUrl;
    private int ranktype;
    private int show_type;
    private String anchor_city;

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_src() {
        return room_src;
    }

    public void setRoom_src(String room_src) {
        this.room_src = room_src;
    }

    public String getVertical_src() {
        return vertical_src;
    }

    public void setVertical_src(String vertical_src) {
        this.vertical_src = vertical_src;
    }

    public int getIsVertical() {
        return isVertical;
    }

    public void setIsVertical(int isVertical) {
        this.isVertical = isVertical;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getShow_status() {
        return show_status;
    }

    public void setShow_status(String show_status) {
        this.show_status = show_status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getOwner_uid() {
        return owner_uid;
    }

    public void setOwner_uid(String owner_uid) {
        this.owner_uid = owner_uid;
    }

    public String getSpecific_catalog() {
        return specific_catalog;
    }

    public void setSpecific_catalog(String specific_catalog) {
        this.specific_catalog = specific_catalog;
    }

    public String getSpecific_status() {
        return specific_status;
    }

    public void setSpecific_status(String specific_status) {
        this.specific_status = specific_status;
    }

    public String getVod_quality() {
        return vod_quality;
    }

    public void setVod_quality(String vod_quality) {
        this.vod_quality = vod_quality;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getChild_id() {
        return child_id;
    }

    public void setChild_id(String child_id) {
        this.child_id = child_id;
    }

    public String getAvatar_mid() {
        return avatar_mid;
    }

    public void setAvatar_mid(String avatar_mid) {
        this.avatar_mid = avatar_mid;
    }

    public String getAvatar_small() {
        return avatar_small;
    }

    public void setAvatar_small(String avatar_small) {
        this.avatar_small = avatar_small;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getRanktype() {
        return ranktype;
    }

    public void setRanktype(int ranktype) {
        this.ranktype = ranktype;
    }

    public int getShow_type() {
        return show_type;
    }

    public void setShow_type(int show_type) {
        this.show_type = show_type;
    }

    public String getAnchor_city() {
        return anchor_city;
    }

    public void setAnchor_city(String anchor_city) {
        this.anchor_city = anchor_city;
    }

    @Override
    public String toString() {
        return "{" +
                "room_id:'" + room_id + '\'' +
                ", room_src:'" + room_src + '\'' +
                ", vertical_src:'" + vertical_src + '\'' +
                ", isVertical:" + isVertical +
                ", cate_id:'" + cate_id + '\'' +
                ", room_name:'" + room_name + '\'' +
                ", show_status:'" + show_status + '\'' +
                ", subject:'" + subject + '\'' +
                ", show_time:'" + show_time + '\'' +
                ", owner_uid:'" + owner_uid + '\'' +
                ", specific_catalog:'" + specific_catalog + '\'' +
                ", specific_status:'" + specific_status + '\'' +
                ", vod_quality:'" + vod_quality + '\'' +
                ", nickname:'" + nickname + '\'' +
                ", online:" + online +
                ", game_name:'" + game_name + '\'' +
                ", child_id:'" + child_id + '\'' +
                ", avatar_mid:'" + avatar_mid + '\'' +
                ", avatar_small:'" + avatar_small + '\'' +
                ", jumpUrl:'" + jumpUrl + '\'' +
                ", ranktype:" + ranktype +
                ", show_type:" + show_type +
                ", anchor_city:'" + anchor_city + '\'' +
                '}';
    }
}
