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
    public ObservableField<String> text = new ObservableField<String>("");
    public ObservableField<String> buttontext = new ObservableField<String>("");
    public ObservableBoolean buttonVisibal = new ObservableBoolean(true);

    public MyEntity(String text, String buttontext) {
        this.text.set(text);
        this.buttontext.set(buttontext);
    }
    public void buttonClick(View view){
        Log.e("adadas","fsfdsf");
        buttonVisibal.set(false);
    }
}
