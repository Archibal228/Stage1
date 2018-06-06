package com.a081995gmail.ivany4.android.classwork2.homework8;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a081995gmail.ivany4.android.R;
import com.a081995gmail.ivany4.android.classwork2.homework7.PublishContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class HoweWork8Activity extends AppCompatActivity implements ObservableContract {


        public Observable<Long> observable;  //почта - умеет получать событие


        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_class_work7);

//            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    publishSubject.onNext(count);
//                    count++;
//                }
//            });

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, FragmentHw8.getInstance());
            fragmentTransaction.commit();
            observable = Observable.interval(1,TimeUnit.SECONDS);
        }


    @Override
    public Observable<Long> getObservable() {
        return observable;
    }
}

