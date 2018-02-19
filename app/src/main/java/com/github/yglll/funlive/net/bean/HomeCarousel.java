package com.github.yglll.funlive.net.bean;

import java.util.List;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/30   22:37
 **/
public class HomeCarousel {
    /*
    {"id":1033935,
    "main_id":36141,
    "source":2,
    "oa_source":21,
    "title":"\u840c\u59b9\u5fcd\u8005\u83e0\u841d\u732b",
    "pic_url":"https:\/\/staticlive.douyucdn.cn\/storage\/webpic_resources\/upload\/slide\/2017\/1225\/201712252112501331.jpg",
    "tv_pic_url":"https:\/\/staticlive.douyucdn.cn\/storage\/webpic_resources\/upload\/slide\/2017\/1225\/201712252112558538.jpg",
    "room":{
        "room_id":"1033935",
        "room_src":"https:\/\/rpic.douyucdn.cn\/anrpic\/171230\/1033935_2224.jpg",
        "vertical_src":"https:\/\/rpic.douyucdn.cn\/anrpic\/171230\/1033935_2224.jpg",
        "isVertical":0,
        "cate_id":"196",
        "room_name":"[\u83e0\u841d\u732b]  \u51c6\u5907\u51c6\u5907\u51c6\u5907\u51c6\u5907\u51c6\u5907~",
        "vod_quality":"0",
        "show_status":"1",
        "show_time":"1514638520",
        "owner_uid":"67648884",
        "specific_catalog":"",
        "specific_status":"0",
        "credit_illegal":"0",
        "is_white_list":"0",
        "cur_credit":"11",
        "low_credit":"4",
        "online":681,
        "nickname":"\u83e0\u841d\u732b\u54c7",
        "url":"\/1033935",
        "game_url":"\/directory\/game\/hyrz",
        "game_name":"\u706b\u5f71\u5fcd\u8005",
        "game_icon_url":"https:\/\/staticlive.douyucdn.cn\/upload\/game_cate\/b780dc8903efd237b7125b5ce92d5aff.jpg",
        "show_details":"\u6e38\u620f\u4ea4\u6d41\u7fa4\uff1a551024592 \n\u76f4\u64ad\u901a\u77e5\u7fa4\uff1a334877806",
        "owner_avatar":"https:\/\/apic.douyucdn.cn\/upload\/avanew\/face\/201712\/04\/01\/2c0e5e18f6be9783cf71d61987602c23_big.jpg?rltime?rltime",
        "cdnsWithName":[
            {"name":"\u4e3b\u7ebf\u8def","cdn":"ws"},
            {"name":"\u5907\u7528\u7ebf\u8def5","cdn":"tct"},
            {"name":"\u5907\u7528\u7ebf\u8def2","cdn":"ws2"}
        ],
        "is_pass_player":0,
        "open_full_screen":0,
        "owner_weight":"3.63t",
        "fans":"51988",
        "column_id":"9",
        "cate_limit":{
            "limit_type":0,
            "limit_num":0,
            "limit_threshold":0,
            "limit_time":0
         }
     }
     }
    */
    private int id;
    private int main_id;
    private int source;
    private int oa_source;
    private String title;
    private String pic_url;
    private TheRoom room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMain_id() {
        return main_id;
    }

    public void setMain_id(int main_id) {
        this.main_id = main_id;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getOa_source() {
        return oa_source;
    }

    public void setOa_source(int oa_source) {
        this.oa_source = oa_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public TheRoom getRoom() {
        return room;
    }

    public void setRoom(TheRoom room) {
        this.room = room;
    }

    public static class TheRoom{
        private int room_id;
        private String room_src;
        private String vertical_src;
        private int isVertical;
        private String cate_id;
        private String room_name;
        private String vod_quality;
        private String show_status;
        private String show_time;
        private String owner_uid;
        private String specific_catalog;
        private String specific_status;
        private String credit_illegal;
        private String is_white_list;
        private String cur_credit;
        private String low_credit;
        private int online;
        private String nickname;
        private String url;
        private String game_url;
        private String game_name;
        private String game_icon_url;
        private String show_details;
        private String owner_avatar;
        private List<TheCdnsWithName> cdnsWithName;
        private int is_pass_player;
        private int open_full_screen;
        private String owner_weight;
        private String fans;
        private String column_id;
        private TheCateLimit cate_limit;

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

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
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

        public String getCredit_illegal() {
            return credit_illegal;
        }

        public void setCredit_illegal(String credit_illegal) {
            this.credit_illegal = credit_illegal;
        }

        public String getIs_white_list() {
            return is_white_list;
        }

        public void setIs_white_list(String is_white_list) {
            this.is_white_list = is_white_list;
        }

        public String getCur_credit() {
            return cur_credit;
        }

        public void setCur_credit(String cur_credit) {
            this.cur_credit = cur_credit;
        }

        public String getLow_credit() {
            return low_credit;
        }

        public void setLow_credit(String low_credit) {
            this.low_credit = low_credit;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
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

        public String getGame_url() {
            return game_url;
        }

        public void setGame_url(String game_url) {
            this.game_url = game_url;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getGame_icon_url() {
            return game_icon_url;
        }

        public void setGame_icon_url(String game_icon_url) {
            this.game_icon_url = game_icon_url;
        }

        public String getShow_details() {
            return show_details;
        }

        public void setShow_details(String show_details) {
            this.show_details = show_details;
        }

        public String getOwner_avatar() {
            return owner_avatar;
        }

        public void setOwner_avatar(String owner_avatar) {
            this.owner_avatar = owner_avatar;
        }

        public List<TheCdnsWithName> getCdnsWithName() {
            return cdnsWithName;
        }

        public void setCdnsWithName(List<TheCdnsWithName> cdnsWithName) {
            this.cdnsWithName = cdnsWithName;
        }

        public int getIs_pass_player() {
            return is_pass_player;
        }

        public void setIs_pass_player(int is_pass_player) {
            this.is_pass_player = is_pass_player;
        }

        public int getOpen_full_screen() {
            return open_full_screen;
        }

        public void setOpen_full_screen(int open_full_screen) {
            this.open_full_screen = open_full_screen;
        }

        public String getOwner_weight() {
            return owner_weight;
        }

        public void setOwner_weight(String owner_weight) {
            this.owner_weight = owner_weight;
        }

        public String getFans() {
            return fans;
        }

        public void setFans(String fans) {
            this.fans = fans;
        }

        public String getColumn_id() {
            return column_id;
        }

        public void setColumn_id(String column_id) {
            this.column_id = column_id;
        }

        public TheCateLimit getCate_limit() {
            return cate_limit;
        }

        public void setCate_limit(TheCateLimit cate_limit) {
            this.cate_limit = cate_limit;
        }

        @Override
        public String toString() {
            return "TheRoom{" +
                    "room_id=" + room_id +
                    ", room_src='" + room_src + '\'' +
                    ", vertical_src='" + vertical_src + '\'' +
                    ", isVertical=" + isVertical +
                    ", cate_id='" + cate_id + '\'' +
                    ", room_name='" + room_name + '\'' +
                    ", vod_quality='" + vod_quality + '\'' +
                    ", show_status='" + show_status + '\'' +
                    ", show_time='" + show_time + '\'' +
                    ", owner_uid='" + owner_uid + '\'' +
                    ", specific_catalog='" + specific_catalog + '\'' +
                    ", specific_status='" + specific_status + '\'' +
                    ", credit_illegal='" + credit_illegal + '\'' +
                    ", is_white_list='" + is_white_list + '\'' +
                    ", cur_credit='" + cur_credit + '\'' +
                    ", low_credit='" + low_credit + '\'' +
                    ", online=" + online +
                    ", nickname='" + nickname + '\'' +
                    ", url='" + url + '\'' +
                    ", game_url='" + game_url + '\'' +
                    ", game_name='" + game_name + '\'' +
                    ", game_icon_url='" + game_icon_url + '\'' +
                    ", show_details='" + show_details + '\'' +
                    ", owner_avatar='" + owner_avatar + '\'' +
                    ", cdnsWithName=" + cdnsWithName +
                    ", is_pass_player=" + is_pass_player +
                    ", open_full_screen=" + open_full_screen +
                    ", owner_weight='" + owner_weight + '\'' +
                    ", fans='" + fans + '\'' +
                    ", column_id='" + column_id + '\'' +
                    ", cate_limit=" + cate_limit +
                    '}';
        }
    }
    public static class TheCdnsWithName{
        private String name;
        private String cdn;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCdn() {
            return cdn;
        }

        public void setCdn(String cdn) {
            this.cdn = cdn;
        }

        @Override
        public String toString() {
            return "TheCdnsWithName{" +
                    "name='" + name + '\'' +
                    ", cdn='" + cdn + '\'' +
                    '}';
        }
    }
    public static class TheCateLimit{
        private int limit_type;
        private int limit_num;
        private int limit_threshold;
        private int limit_time;

        public int getLimit_type() {
            return limit_type;
        }

        public void setLimit_type(int limit_type) {
            this.limit_type = limit_type;
        }

        public int getLimit_num() {
            return limit_num;
        }

        public void setLimit_num(int limit_num) {
            this.limit_num = limit_num;
        }

        public int getLimit_threshold() {
            return limit_threshold;
        }

        public void setLimit_threshold(int limit_threshold) {
            this.limit_threshold = limit_threshold;
        }

        public int getLimit_time() {
            return limit_time;
        }

        public void setLimit_time(int limit_time) {
            this.limit_time = limit_time;
        }

        @Override
        public String toString() {
            return "TheCateLimit{" +
                    "limit_type=" + limit_type +
                    ", limit_num=" + limit_num +
                    ", limit_threshold=" + limit_threshold +
                    ", limit_time=" + limit_time +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HomeCarousel{" +
                "id=" + id +
                ", main_id=" + main_id +
                ", source=" + source +
                ", oa_source=" + oa_source +
                ", title='" + title + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", room=" + room +
                '}';
    }
}
