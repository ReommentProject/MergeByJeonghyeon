package com.example.recyclerviewinsidefragment;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("id")
    private int thumbnail;

    @SerializedName("name")
    private String title;

    @SerializedName("age")
    private int content;


    public Content(int thumbnail, String title, int content) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.content = content;
    }

    public int getThumbnail() { return thumbnail; }
    public String getTitle() { return title; }
    public int getContent() {
        return content;
    }
}
