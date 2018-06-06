package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;

import com.a081995gmail.ivany4.android.classwork2.pressentation.base.Router;

/**
 * Created by Archibal on 06.04.2018.
 */

public class UserRouter extends Router {

    public UserRouter(Activity activity) {
        super(activity);
    }

    public void navigateToUser(String id){
        Intent intent = new Intent(getActivity(),UserActivity.class);
        intent.putExtra("key", id);
        getActivity().startActivity(intent);
    }

    public void back(){

        getActivity().onBackPressed();

    }

}
