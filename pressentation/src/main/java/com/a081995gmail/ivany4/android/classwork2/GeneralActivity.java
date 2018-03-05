package com.a081995gmail.ivany4.android.classwork2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.classwork2.classwork7.ClassWork7Activity;
import com.a081995gmail.ivany4.android.classwork2.homework2.FlagsActivity;
import com.a081995gmail.ivany4.android.classwork2.homework3.HomeWork3Activity;
import com.a081995gmail.ivany4.android.classwork2.homework4.HomeWork4Activity;
import com.a081995gmail.ivany4.android.classwork2.homework5.HomeWork5Activity;
import com.a081995gmail.ivany4.android.classwork2.homework6.HomeWork6Activity;
import com.a081995gmail.ivany4.android.classwork2.hw1.hw1_activity;

public class GeneralActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_hw1, btn_hw2, btn_hw3, btn_hw4, btn_hw5, btn_hw6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        btn_hw1 = findViewById(R.id.btn_hw1);
        btn_hw2 = findViewById(R.id.btn_hw2);
        btn_hw3 = findViewById(R.id.btn_hw3);
        btn_hw4 = findViewById(R.id.btn_hw4);
        btn_hw5 =findViewById(R.id.btn_hw5);
        btn_hw6 = findViewById(R.id.btn_hw6);
        btn_hw1.setOnClickListener(this);
        btn_hw2.setOnClickListener(this);
        btn_hw3.setOnClickListener(this);
        btn_hw4.setOnClickListener(this);
        btn_hw5.setOnClickListener(this);
        btn_hw6.setOnClickListener(this);

        //btn_hw3.setText(BuildConfig.Api_URL);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hw1:
                Intent intent = new Intent(this, hw1_activity.class);
                startActivity(intent);
                break;
            case R.id.btn_hw2:
                Intent intent2 = new Intent(this, FlagsActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_hw3:
                Intent intent3 = new Intent(this, HomeWork3Activity.class);
                startActivity(intent3);
                break;
            case R.id.btn_hw4:
                Intent intent4 = new Intent(this, HomeWork4Activity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                break;
            case R.id.btn_hw5:
                Intent intent5 = new Intent(this, HomeWork5Activity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                break;
            case R.id.btn_hw6:
                Intent intent6 = new Intent(this, HomeWork6Activity.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                break;
        }
    }
}
