package com.example.studentscaco.utils.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Scholarship extends RealmObject {
    @PrimaryKey private String name;
    @Required private String date;
    @Required private String desc;
    @Required private String img;
    @Required private String url;

    public Scholarship(){

    }
    public Scholarship(String name, String date, String desc, String img, String url) {
        this.name = name;
        this.date = date;
        this.desc = desc;
        this.img = img;
        this.url = url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
