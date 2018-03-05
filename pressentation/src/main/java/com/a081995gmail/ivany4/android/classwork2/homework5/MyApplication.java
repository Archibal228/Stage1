package com.a081995gmail.ivany4.android.classwork2.homework5;

import android.app.Application;

/**
 * Created by Archibal on 01.03.2018.
 */

public class MyApplication extends Application {
    public static boolean activityVisible; // Variable that will check the
    // current activity state

    public static boolean isActivityVisible() {
        return activityVisible; // return true or false
    }

    public static void activityResumed() {
        activityVisible = true;// this will set true when activity resumed

    }

    public static void activityPaused() {
        activityVisible = false;// this will set false when activity paused

    }
}
