package com.a081995gmail.ivany4.android.classwork2.homework5;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.io.FileDescriptor;

public class ChangeWiFiService extends Service {
    final String Log_TAG = "myLog";
    private  final IBinder iBinder = new LocalBinder();
    public class LocalBinder extends Binder {
        ChangeWiFiService getService(){
            return ChangeWiFiService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Log_TAG,"onBind");
        return iBinder;
    }
    public void Chager(){
        WifiManager wifi = (WifiManager) this.getSystemService(WIFI_SERVICE);
        if(wifi.isWifiEnabled()) {
            wifi.setWifiEnabled(false);
            Log.d(Log_TAG, "OFF");
        }else{
            wifi.setWifiEnabled(true);
            Log.d(Log_TAG,"ON!!!");

        }
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Log_TAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
