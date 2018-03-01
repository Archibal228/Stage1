package com.a081995gmail.ivany4.android.classwork2.homework4;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.a081995gmail.ivany4.android.R;

public class AnimActivity extends AppCompatActivity {


    private ImageView sova;
    AnimationDrawable anim_sova;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        sova = findViewById(R.id.sova);
        sova.setBackgroundResource(R.drawable.sova_anim);
        anim_sova = (AnimationDrawable) sova.getBackground();
        anim_sova.start();


    }
}
