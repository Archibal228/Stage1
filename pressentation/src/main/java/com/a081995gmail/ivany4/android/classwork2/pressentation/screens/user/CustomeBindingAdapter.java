package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Archibal on 29.03.2018.
 */

public class CustomeBindingAdapter {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext()).load(url).apply(RequestOptions.circleCropTransform()).into(imageView);
    }
}
