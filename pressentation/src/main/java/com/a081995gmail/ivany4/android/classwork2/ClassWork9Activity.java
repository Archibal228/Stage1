package com.a081995gmail.ivany4.android.classwork2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.databinding.ActivityClassWork9Binding;


public class ClassWork9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_class_work9);
        MyEntity myEntity = new MyEntity("Hello", "Click");
        ActivityClassWork9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_class_work9);
        binding.setMyEntity(myEntity);
    }
    }

