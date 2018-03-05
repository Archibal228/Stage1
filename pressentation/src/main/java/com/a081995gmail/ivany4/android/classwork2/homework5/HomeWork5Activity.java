package com.a081995gmail.ivany4.android.classwork2.homework5;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.a081995gmail.ivany4.android.R;

public class HomeWork5Activity extends AppCompatActivity implements View.OnClickListener {
    private static ImageView wifi_img;
    private Button change_btn;
    private ServiceConnection sConn;
    boolean bound;
    final String LOG_TAG = "MeLog";
    private ChangeWiFiService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work5);
        Log.d(LOG_TAG, "onCreate");
        wifi_img = findViewById(R.id.wifi_state);
        change_btn = findViewById(R.id.on_off_btn);
        change_btn.setOnClickListener(this);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            changeImage(true);
        } else {
            changeImage(false);
        }
    }

//        WifiManager wifi = (WifiManager) this.getApplicationContext().getSystemService(WIFI_SERVICE);
//        if (wifi.isWifiEnabled()) {
//            wifi_img.setImageResource(R.drawable.ic_signal_wifi_4_bar_black_24dp);
//
//        } else
//            wifi_img.setImageResource((R.drawable.ic_signal_wifi_off_black_24dp));
//    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onResume");
        MyApplication.activityResumed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG_TAG, "onStart");

        Intent intent = new Intent(this, ChangeWiFiService.class);
        sConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.d(LOG_TAG, "MainActivity onServiceConnected");
                ChangeWiFiService.LocalBinder mybinder = (ChangeWiFiService.LocalBinder) binder;
                mService = mybinder.getService();
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                Log.d(LOG_TAG, "MainActivity onServiceDisconnected");
                bound = false;
            }
        };
        bindService(intent, sConn, BIND_AUTO_CREATE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        MyApplication.activityPaused();

    }

    public  static void changeImage(boolean isConnected){
        if (isConnected){
            wifi_img.setImageResource(R.drawable.ic_signal_wifi_4_bar_black_24dp);
        }else{
            wifi_img.setImageResource(R.drawable.ic_signal_wifi_off_black_24dp);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(sConn);
    }
    @Override
    public void onClick(View v) {
//        WifiManager wifi = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
//        if(wifi.isWifiEnabled()) {
//            wifi.setWifiEnabled(false);
//            changeImage(false);
//        }else{
//            wifi.setWifiEnabled(true);
//            changeImage(true);
//        }
        mService.Chager();
    }
}
