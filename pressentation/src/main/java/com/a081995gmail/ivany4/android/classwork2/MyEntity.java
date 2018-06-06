package com.a081995gmail.ivany4.android.classwork2;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by Archibal on 05.03.2018.
 */

public class MyEntity {
    public String text;
    public String buttontext;
    public boolean buttonVisibal =true;

    public MyEntity(String text, String buttontext) {
        this.text=text;
        this.buttontext = buttontext;
    }
    public void buttonClick(View view){
        Log.e("adadas","fsfdsf");

    }
}
