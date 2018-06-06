package com.a081995gmail.ivany4.android.classwork2.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.a081995gmail.ivany4.android.BuildConfig;
import com.a081995gmail.ivany4.android.classwork2.executor.UIThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import e.archibal.data.db.AppDataBase;
import e.archibal.data.repository.UserRepositoryImpl;
import e.archibal.data.rest.RestApi;
import e.archibal.data.rest.RestService;
import e.archibal.domain.executor.PostExecutionThread;
import e.archibal.domain.repository.UserRepository;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Archibal on 19.03.2018.
 */
@Module
public  class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }
    @Provides
    @Singleton
    public AppDataBase getAppDataBase(Context context){
        AppDataBase appDataBase = Room.databaseBuilder(context, AppDataBase.class, "database")
                .fallbackToDestructiveMigration()
                .build();
        return appDataBase;
    }

    @Provides
    public UserRepository getUserRepository(Context context, RestService restService,AppDataBase dataBase) {
        return new UserRepositoryImpl(context, restService,dataBase);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient).baseUrl("https://api.backendless.com/AFBA53A5-EC03-38A9-FFE5-36B3315DD900/2FE78199-7AC8-D9DD-FF68-E1085DEA3700/").build();
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).connectTimeout(5, TimeUnit.SECONDS);
        //                модификация запроса
        //                .addInterceptor()
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    public Gson getGson(){
        return  new GsonBuilder()
                .create();
    }
}