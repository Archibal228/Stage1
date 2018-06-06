package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user.list;

import android.view.ViewGroup;

import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseAdapter;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseItemViewHolder;

import java.util.List;

import e.archibal.domain.entity.UserEntity;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Archibal on 02.04.2018.
 */

public class UserAdapter extends BaseAdapter<UserEntity,UserItemViewModel> {


    @Override
    public BaseItemViewHolder<UserEntity, UserItemViewModel, ?> onCreateViewHolder(ViewGroup parent, int viewType) {
        return UserItemViewHolder.create(parent, new UserItemViewModel());
    }
}
