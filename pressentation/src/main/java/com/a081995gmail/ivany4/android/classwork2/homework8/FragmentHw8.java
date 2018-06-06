package com.a081995gmail.ivany4.android.classwork2.homework8;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a081995gmail.ivany4.android.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Archibal on 14.03.2018.
 */

public class FragmentHw8 extends Fragment {
    public TextView textView;
    public Observable observable;
    private Disposable disposable;
    private ObservableContract publishContract;


    public static FragmentHw8 getInstance(){
        return new FragmentHw8();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        textView = view.findViewById(R.id.count_text);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //to do click
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        subscribe();
    }

    private void subscribe(){
        disposable = publishContract
                .getObservable()
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }


                })
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong % 2 == 0;
                    }


                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //трансформация данных из Int в String
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return String.valueOf(aLong);
                    }

                })
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                })

                //  .take(8) //можно поставить счетчик по которому завршить подписку
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        textView.setText(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        // произойдет ,если все плохо
                        // ,сюда прилетают ошибки

                    }
                });
    }


    @Override
    public void onPause() {
        super.onPause();
        if (disposable != null){
            disposable.dispose(); // метод для отписки
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity!=null){
            publishContract = (ObservableContract) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        publishContract = null;
    }
}


