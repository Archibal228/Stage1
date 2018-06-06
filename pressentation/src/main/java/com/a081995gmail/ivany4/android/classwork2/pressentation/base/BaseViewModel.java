package com.a081995gmail.ivany4.android.classwork2.pressentation.base;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;



public abstract class BaseViewModel<R extends Router> extends ViewModel {
protected CompositeDisposable compositeDisposable = new CompositeDisposable();
protected R router;
    public BaseViewModel() {
        createInject();
    }

    public abstract void createInject();
    public void onResume(){

    }
    public void attachRouter(R router){
        this.router = router;
    }

    public void detachRouter(){
        router =  null;
    }
    public void onPause(){

    }
    public void onStart(){

    }
    public  void onStop(){

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}
