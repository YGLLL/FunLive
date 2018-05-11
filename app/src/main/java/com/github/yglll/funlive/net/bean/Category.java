package com.github.yglll.funlive.net.bean;


public class Category {
    /*
    {
      "cate_id": 270,
      "game_name": "绝地求生",
      "short_name": "jdqs",
      "game_url": "http://www.douyu.com/directory/game/jdqs",
      "game_src": "https://staticlive.douyucdn.cn/upload/game_cate/63a6c37b1bece659805e58ffeac6d00a.jpg",
      "game_icon": "https://staticlive.douyucdn.cn/upload/game_cate/5a92cff5881b5c62814f5289c79b38cf.jpg"
    }
    */
    private int cate_id;
    private String game_name;
    private String short_name;
    private String game_url;
    private String game_src;
    private String game_icon;

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getGame_url() {
        return game_url;
    }

    public void setGame_url(String game_url) {
        this.game_url = game_url;
    }

    public String getGame_src() {
        return game_src;
    }

    public void setGame_src(String game_src) {
        this.game_src = game_src;
    }

    public String getGame_icon() {
        return game_icon;
    }

    public void setGame_icon(String game_icon) {
        this.game_icon = game_icon;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cate_id=" + cate_id +
                ", game_name='" + game_name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", game_url='" + game_url + '\'' +
                ", game_src='" + game_src + '\'' +
                ", game_icon='" + game_icon + '\'' +
                '}';
    }
}
