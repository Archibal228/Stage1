package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseItemViewHolder;
import com.a081995gmail.ivany4.android.databinding.ItemUserBinding;

import e.archibal.domain.entity.UserEntity;

/**
 * Created by Archibal on 02.04.2018.
 */

public class UserItemViewHolder extends BaseItemViewHolder<UserEntity,UserItemViewModel, ItemUserBinding> {
    public UserItemViewHolder(ItemUserBinding binding, UserItemViewModel viewModel) {
        super(binding, viewModel);
    }
    public static UserItemViewHolder create(ViewGroup parent, UserItemViewModel viewModel){
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);


        BaseItemViewHolder holder = new UserItemViewHolder(binding, new UserItemViewModel());

        return new UserItemViewHolder(binding,viewModel);
    }
}
