package com.a081995gmail.ivany4.android.classwork2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a081995gmail.ivany4.android.BuildConfig;
import com.a081995gmail.ivany4.android.R;

public class ClassWork3Activity extends AppCompatActivity implements View.OnClickListener {
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work3);
        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        btn1.setText(BuildConfig.Api_URL);
    }
}
