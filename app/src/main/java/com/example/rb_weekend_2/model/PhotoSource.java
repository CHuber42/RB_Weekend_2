package com.example.rb_weekend_2.model;

import java.io.Serializable;

public class PhotoSource implements Serializable {

    private String original;
    private String large2x;
    private String large;
    private String medium;
    private String small;
    private String portrait;
    private String landscape;
    private String tiny;

    public PhotoSource(String original, String large2x, String large, String medium, String small, String portrait, String landscape, String tiny) {
        this.original = original;
        this.large2x = large2x;
        this.large = large;
        this.medium = medium;
        this.small = small;
        this.portrait = portrait;
        this.landscape = landscape;
        this.tiny = tiny;
    }

    public String getOriginal() {
        return original;
    }

    public String getLarge2x() {
        return large2x;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getSmall() {
        return small;
    }

    public String getPortrait() {
        return portrait;
    }

    public String getLandscape() {
        return landscape;
    }

    public String getTiny() {
        return tiny;
    }
}
