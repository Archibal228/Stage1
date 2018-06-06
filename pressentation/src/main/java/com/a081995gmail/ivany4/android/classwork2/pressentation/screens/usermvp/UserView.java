package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.usermvp;

import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseView;

import e.archibal.domain.entity.UserEntity;

/**
 * Created by Archibal on 09.04.2018.
 */

public interface UserView extends BaseView {

    void showUser(UserEntity userEntity);
}
