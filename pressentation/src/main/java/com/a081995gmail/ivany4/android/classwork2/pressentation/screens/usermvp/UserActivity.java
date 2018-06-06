package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.usermvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseMvpActivity;
import com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user.UserRouter;

import e.archibal.domain.entity.UserEntity;


public class UserActivity extends BaseMvpActivity<UserPresenter, UserRouter> implements UserView{


public static void show(Activity activity, String id){
    Intent intent = new Intent(activity, UserActivity.class);
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
    public UserPresenter providePresenter() {
        return new SingInUserPresenter();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        RecyclerView recycleview = findViewById(R.id.recycleview);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setHasFixedSize(true);
        recycleview.setAdapter(presenter.getUserAdapter());
        presenter.onUserClick();
    }


    @Override
    public void showUser(UserEntity userEntity) {
        //закиываем данные в xml
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismisssProgress() {

    }

    @Override
    public void showError(Exception e) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

