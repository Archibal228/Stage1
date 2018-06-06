package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user;


import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.a081995gmail.ivany4.android.classwork2.UserAdapter;
import com.a081995gmail.ivany4.android.classwork2.app.App;
import com.a081995gmail.ivany4.android.classwork2.executor.UIThread;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseViewModel;

import javax.inject.Inject;

import e.archibal.data.db.AppDataBase;
import e.archibal.data.entity.Error;
import e.archibal.data.entity.ErrorType;
import e.archibal.data.repository.UserRepositoryImpl;
import e.archibal.data.rest.RestService;
import e.archibal.domain.entity.UserEntity;
import e.archibal.domain.interacrors.GetUserByIdUseCase;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends BaseViewModel<UserRouter> {
    public UserAdapter userAdapter = new UserAdapter();

    @Inject
    Context context;
    RestService restService;
    AppDataBase appDataBase;
    @Inject
public GetUserByIdUseCase getUserByIdUseCase; //= new GetUserByIdUseCase(new UIThread(),new UserRepositoryImpl(context,restService,appDataBase));
    public ObservableField<String> username = new ObservableField<String>("");
    public ObservableField<String> profileUrl = new ObservableField<String>("");
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean progressVisibal = new ObservableBoolean(false);
    //public CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }
    public UserViewModel() {
        super();
        if(router != null) router.navigateToUser("dsdffdf");

        progressVisibal.set(true);
        getUserByIdUseCase.get("id")
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("AAA", "onSubscribe()");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(UserEntity userEntity) {
                        Log.e("AAA", "onNext()");
                        username.set(userEntity.getUserName());
                        profileUrl.set(userEntity.getUrl());
                        age.set(userEntity.getAge());


                    }

                    @Override
                    public void onError(Throwable e) {

                        if (e instanceof Error){
                            Error myError = (Error) e;
                            if (myError.getFriendlyError()== ErrorType.No_Internet);
                        }


                        Log.e("AAA", "onError()");

                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAA", "onComplete()");
                        progressVisibal.set(false);

                    }
                });


    }

}
