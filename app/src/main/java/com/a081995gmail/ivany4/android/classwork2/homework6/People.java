package com.a081995gmail.ivany4.android.classwork2.homework6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Archibal on 02.03.2018.
 */

public class People {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("isDegree")
    @Expose
    private Boolean isDegree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsDegree() {
        return isDegree;
    }

    public void setIsDegree(Boolean isDegree) {
        this.isDegree = isDegree;

}

}
