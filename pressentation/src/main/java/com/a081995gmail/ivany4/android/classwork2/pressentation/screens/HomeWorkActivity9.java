package com.a081995gmail.ivany4.android.classwork2.pressentation.screens;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.databinding.ActivityUserBinding;

import e.archibal.data.entity.User;

/**
 * Created by Archibal on 29.03.2018.
 */

public class HomeWorkActivity9 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        User user = new User("Artem Ivanov", 18, "https://ldpr.ru/static/uploads/6dce5a7c9e_IMG_1833.JPG", true);

        binding.setViewModel(user);

    }
}

