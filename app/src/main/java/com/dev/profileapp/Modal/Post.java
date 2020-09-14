package com.dev.profileapp.Modal;


import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;

    private String title;

    @SerializedName("body")
    private String desc;

    public Post(int id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
