package com.a081995gmail.ivany4.android.classwork2;

/**
 * Created by Archibal on 23.02.2018.
 */

public class User {

    public String imageUrl;
    public String name;
    public int age;

    public User(String imageUrl, String name, String suname) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.suname = suname;
    }

    private String suname;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }
}
