package com.a081995gmail.ivany4.android.classwork2.app;

import android.app.Application;

import com.a081995gmail.ivany4.android.classwork2.homework7.PublishContract;
import com.a081995gmail.ivany4.android.classwork2.injection.AppComponent;
import com.a081995gmail.ivany4.android.classwork2.injection.AppModule;
import com.a081995gmail.ivany4.android.classwork2.injection.DaggerAppComponent;


/**
 * Created by Archibal on 19.03.2018.
 */

public class App extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
