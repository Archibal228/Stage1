package com.a081995gmail.ivany4.android.classwork2;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Archibal on 19.02.2018.
 */

public class MyIntentService extends IntentService {
     public static final String KEY_LINK ="KEY_LINK";


    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String link = intent.getStringExtra(KEY_LINK);
        Log.e("AAA", "IntentService");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}