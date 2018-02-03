package com.github.yglll.funlive.model.logic;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2018/01/26   22:40
 **/
public class HomeRecommendHotCate {

    private String push_vertical_screen;
    private String icon_url;
    private String tag_name;
    private String push_nearby;
    private String tag_id;

    private List<RoomListEntity> room_list;

    public String getPush_vertical_screen() {
        return push_vertical_screen;
    }

    public void setPush_vertical_screen(String push_vertical_screen) {
        this.push_vertical_screen = push_vertical_screen;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getPush_nearby() {
        return push_nearby;
    }

    public void setPush_nearby(String push_nearby) {
        this.push_nearby = push_nearby;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public List<RoomListEntity> getRoom_list() {
        return room_list;
    }

    public void setRoom_list(List<RoomListEntity> room_list) {
        this.room_list = room_list;
    }

    public static class RoomListEntity implements Serializable {
        private String specific_catalog;
        private String vertical_src;
        private String ranktype;
        private String nickname;
        private String subject;
        private String room_src;
        private String cate_id;
        private String specific_status;
        private String game_name;
        private String avatar_small;
        private int online;
        private String avatar_mid;
        private String vod_quality;
        private String room_name;
        private String child_id;
        private String room_id;
        private String show_time;
        private int isVertical;
        private String show_status;
        private String jumpUrl;

        public String getSpecific_catalog() {
            return specific_catalog;
        }

        public void setSpecific_catalog(String specific_catalog) {
            this.specific_catalog = specific_catalog;
        }

        public String getVertical_src() {
            return vertical_src;
        }

        public void setVertical_src(String vertical_src) {
            this.vertical_src = vertical_src;
        }

        public String getRanktype() {
            return ranktype;
        }

        public void setRanktype(String ranktype) {
            this.ranktype = ranktype;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getRoom_src() {
            return room_src;
        }

        public void setRoom_src(String room_src) {
            this.room_src = room_src;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getSpecific_status() {
            return specific_status;
        }

        public void setSpecific_status(String specific_status) {
            this.specific_status = specific_status;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getAvatar_mid() {
            return avatar_mid;
        }

        public void setAvatar_mid(String avatar_mid) {
            this.avatar_mid = avatar_mid;
        }

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getChild_id() {
            return child_id;
        }

        public void setChild_id(String child_id) {
            this.child_id = child_id;
        }

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }

        public int getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(int isVertical) {
            this.isVertical = isVertical;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }
        @Override
        public String toString() {
            return "{" +
                    "specific_catalog:'" + specific_catalog + '\'' +
                    ", vertical_src:'" + vertical_src + '\'' +
                    ", ranktype:'" + ranktype + '\'' +
                    ", nickname:'" + nickname + '\'' +
                    ", subject:'" + subject + '\'' +
                    ", room_src:'" + room_src + '\'' +
                    ", cate_id:'" + cate_id + '\'' +
                    ", specific_status:'" + specific_status + '\'' +
                    ", game_name:'" + game_name + '\'' +
                    ", avatar_small:'" + avatar_small + '\'' +
                    ", online:" + online +
                    ", avatar_mid:'" + avatar_mid + '\'' +
                    ", vod_quality:'" + vod_quality + '\'' +
                    ", room_name:'" + room_name + '\'' +
                    ", child_id:'" + child_id + '\'' +
                    ", room_id:'" + room_id + '\'' +
                    ", show_time:'" + show_time + '\'' +
                    ", isVertical:" + isVertical +
                    ", show_status:'" + show_status + '\'' +
                    ", jumpUrl:'" + jumpUrl + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "{" +
                "push_vertical_screen:'" + push_vertical_screen + '\'' +
                ", icon_url:'" + icon_url + '\'' +
                ", tag_name:'" + tag_name + '\'' +
                ", push_nearby:'" + push_nearby + '\'' +
                ", tag_id:'" + tag_id + '\'' +
                ", room_list:" + room_list +
                '}';
    }
}
