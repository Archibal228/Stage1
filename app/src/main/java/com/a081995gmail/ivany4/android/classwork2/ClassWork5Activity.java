package com.a081995gmail.ivany4.android.classwork2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.a081995gmail.ivany4.android.R;

public class ClassWork5Activity extends AppCompatActivity implements View.OnClickListener {
private Button button;
private  static final String TAG = ClassWork5Activity.class.getSimpleName();
private static final String Action_My_Message = "com.a081995gmail.ivany4.android.classwork2.Action_My_Message";
private LocalBroadcastManager broadcastMeneger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work5);
        broadcastMeneger = LocalBroadcastManager.getInstance(ClassWork5Activity.this);

    }
    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("Aaaaaaa", "Massage");
        }


    };

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Action_My_Message);
        broadcastMeneger.registerReceiver(myReceiver, intentFilter);

        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Intent intent2 = new Intent(this, MyService.class);
        intent2.putExtra(MyIntentService.KEY_LINK, "http//film1");
        startService(intent2);
        Intent intent3 = new Intent(this, MyService.class);
        intent3.putExtra(MyIntentService.KEY_LINK, "http//film2");

        startService(intent3);
        Intent intent4 = new Intent(this, MyService.class);
        intent4.putExtra(MyIntentService.KEY_LINK, "http//film3");

        startService(intent4);
    }

    @Override
    protected void onStop() {
        super.onStop();
        broadcastMeneger.unregisterReceiver(myReceiver);
        stopService(new Intent(this, MyService.class));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Action_My_Message);
        broadcastMeneger.sendBroadcast(intent);

    }
}
