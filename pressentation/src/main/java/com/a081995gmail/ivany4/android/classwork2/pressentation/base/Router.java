package com.a081995gmail.ivany4.android.classwork2.pressentation.base;

import android.app.Activity;

/**
 * Created by Archibal on 06.04.2018.
 */

public abstract class Router {

    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public Router(Activity activity) {
        this.activity = activity;
    }
}
