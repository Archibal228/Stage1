package com.a081995gmail.ivany4.android.classwork2.pressentation.screens.usermvp;

import android.util.Log;

import com.a081995gmail.ivany4.android.classwork2.UserAdapter;
import com.a081995gmail.ivany4.android.classwork2.app.App;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseView;

import javax.inject.Inject;

import e.archibal.data.entity.Error;
import e.archibal.data.entity.ErrorType;
import e.archibal.domain.entity.UserEntity;
import e.archibal.domain.interacrors.GetUserByIdUseCase;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Archibal on 09.04.2018.
 */

public class SingInUserPresenter extends UserPresenter {
    @Inject
    public GetUserByIdUseCase getUserByIdUseCase;

    public UserAdapter userAdapter = new UserAdapter();
    @Override
    public void createInject() {
        App.getAppComponent().inject(this);
    }

    public SingInUserPresenter() {
        view.showProgress();
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
                        view.showUser(userEntity);
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
                        view.dismisssProgress();

                    }
                });


    }

    @Override
    public void onUserClick() {

    }

    @Override
    public UserAdapter getUserAdapter() {
        return userAdapter;
    }
}
