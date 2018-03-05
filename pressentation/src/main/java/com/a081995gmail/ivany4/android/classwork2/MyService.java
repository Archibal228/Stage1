package com.a081995gmail.ivany4.android.classwork2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Archibal on 19.02.2018.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Servive","onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Servive","onBind");

        return null;

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Servive","onUnBind");

        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Servive","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

}
