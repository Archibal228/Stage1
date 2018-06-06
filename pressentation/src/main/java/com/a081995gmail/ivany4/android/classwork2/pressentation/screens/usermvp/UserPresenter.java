package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.usermvp;

import com.a081995gmail.ivany4.android.classwork2.UserAdapter;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BasePresenter;

/**
 * Created by Archibal on 09.04.2018.
 */

public abstract class UserPresenter extends BasePresenter<UserRouter, UserView> {

    public abstract void onUserClick();
    public abstract UserAdapter getUserAdapter();
}
