package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseAdapter;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseMvvmActivity;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseViewModel;
import com.a081995gmail.ivany4.android.classwork2.pressentation.utils.ImageChooser;
import com.a081995gmail.ivany4.android.databinding.ActivityUserBinding;

import java.io.File;
import java.util.HashMap;


public class UserActivity extends BaseMvvmActivity<ActivityUserBinding, UserViewModel,UserRouter> {


public static void show(Activity activity, String id){
    Intent intent = new Intent(activity,UserActivity.class);
    intent.putExtra("key", id);
    activity.startActivity(intent);
}
    @Override
    public int provideLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public UserRouter provideRouter() {
        return null;
    }


    @Override
    public UserViewModel provideViewModel() {
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        return userViewModel;
    }
 protected void onActivityResult(int requestCode,int resultCode,Intent data){
    if (requestCode == Activity.RESULT_OK){
        File file = ImageChooser.getImageFromResult(this,requestCode, resultCode, data);


    }
 }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding.recycleview.setLayoutManager(new LinearLayoutManager(this));
//        binding.recycleview.setHasFixedSize(true);
//        binding.recycleview.setAdapter(viewModel.userAdapter);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_list_black_24dp);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.optional_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.actionSearch : {
            break;
        }
    }
        return super.onOptionsItemSelected(item);
    }
}

