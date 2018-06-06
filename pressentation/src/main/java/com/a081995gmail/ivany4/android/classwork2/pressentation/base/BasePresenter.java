package com.a081995gmail.ivany4.android.classwork2.pressentation.base;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.a081995gmail.ivany4.android.classwork2.pressentation.screens.usermvp.UserView;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BasePresenter<R extends Router, View extends UserView> {
    @Nullable
    protected View view;

    @Nullable
    protected R router;
protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BasePresenter() {
        createInject();
    }

    public abstract void createInject();
    public void onResume(){

    }
    public void attach(R router, View view){
        this.router = router;
        this.view = view;
    }

    public void detach(){
        router =  null;
        view = null;
    }
    public void onPause(){

    }
    public void onStart(){

    }

    public  void onStop(){

    }

    public void onDestroy(){
        if (!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
    }




    }
}
