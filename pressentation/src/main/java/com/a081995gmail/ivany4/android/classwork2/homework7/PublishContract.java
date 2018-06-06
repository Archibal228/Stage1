package com.a081995gmail.ivany4.android.classwork2.homework7;

import io.reactivex.subjects.PublishSubject;

public interface PublishContract {
    PublishSubject<Integer> getObservable();
}