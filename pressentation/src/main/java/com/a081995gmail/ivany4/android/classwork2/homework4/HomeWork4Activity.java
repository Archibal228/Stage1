package com.a081995gmail.ivany4.android.classwork2.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.classwork2.ClasssWork4Activity;

public class HomeWork4Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_anim;
    private Button btn_clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work4);
        btn_anim = findViewById(R.id.anim);
        btn_clock = findViewById((R.id.clock));
        btn_clock.setOnClickListener(this);
        btn_anim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.anim:
                Intent intent = new Intent(this, AnimActivity.class);
                startActivity(intent);
                break;
            case R.id.clock:
                Intent intent2 = new Intent(this, ClockActivity.class);
                startActivity(intent2);
                break;

        }

    }
}
