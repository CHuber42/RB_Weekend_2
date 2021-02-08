package com.example.rb_weekend_2.model;

import java.io.Serializable;

public class Photo implements Serializable {

    private final int id;
    private final int width;
    private final int height;
    private final String url;
    private final String photographer;
    private final String photographer_url;
    private final int photographer_id;
    private final String avg_color;
    private final PhotoSource src;
    private final boolean liked;


    public Photo(int id, int width, int height, String url, String photographer, String photographer_url, int photographer_id, String avg_color, PhotoSource src, boolean liked) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.url = url;
        this.photographer = photographer;
        this.photographer_url = photographer_url;
        this.photographer_id = photographer_id;
        this.avg_color = avg_color;
        this.src = src;
        this.liked = liked;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }

    public String getPhotographer() {
        return photographer;
    }

    public String getPhotographer_url() {
        return photographer_url;
    }

    public int getPhotographer_id() {
        return photographer_id;
    }

    public String getAvg_color() {
        return avg_color;
    }

    public PhotoSource getSrc() {
        return src;
    }

    public boolean isLiked() {
        return liked;
    }





}
