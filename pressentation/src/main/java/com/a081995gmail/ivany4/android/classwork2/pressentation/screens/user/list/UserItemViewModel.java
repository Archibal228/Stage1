package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user.list;

import android.databinding.ObservableField;

import com.a081995gmail.ivany4.android.classwork2.User;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseItemViewModel;

import e.archibal.domain.entity.UserEntity;
import io.reactivex.Observable;

/**
 * Created by Archibal on 02.04.2018.
 */

public class UserItemViewModel extends BaseItemViewModel<UserEntity> {

   public ObservableField<String> name = new ObservableField<>("");
   public ObservableField<String> age = new ObservableField<>("");

    @Override
    public void setItem(UserEntity userEntity, int position) {
        name.set(userEntity.getUserName());
        age.set(String.valueOf(userEntity.getAge()));

    }
}
