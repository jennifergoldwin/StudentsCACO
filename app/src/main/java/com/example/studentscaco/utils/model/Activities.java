package com.example.studentscaco.utils.model;

public class Activities {
    private String _id;
    private String date;
    private String desc;
    private String url;
    private String title;
    private String type;

    public Activities(){

    }
    public Activities(String _id,  String date, String desc,  String url, String title,String type) {
        this._id = _id;
        this.type = type;
        this.date = date;
        this.desc = desc;
        this.url = url;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
