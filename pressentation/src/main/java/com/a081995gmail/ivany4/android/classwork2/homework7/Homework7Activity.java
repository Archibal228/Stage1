package com.a081995gmail.ivany4.android.classwork2.homework7;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.a081995gmail.ivany4.android.R;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class Homework7Activity extends AppCompatActivity implements PublishContract{

    public PublishSubject<Integer> publishSubject =PublishSubject.create(); //почта - умеет получать событие
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work7);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publishSubject.onNext(count);
                count++;
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container ,OneFragmentHw7.getInstance());
        fragmentTransaction.commit();
    }


    @Override
    public Observable<Integer> getObservable() {
        return publishSubject;
    }
}
