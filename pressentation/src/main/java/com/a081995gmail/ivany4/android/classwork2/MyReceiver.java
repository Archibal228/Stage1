package com.a081995gmail.ivany4.android.classwork2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Archibal on 19.02.2018.
 */
//сюда будут прилетать события на которые мы подписались

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AAAAAA", "Message");
    }
}
