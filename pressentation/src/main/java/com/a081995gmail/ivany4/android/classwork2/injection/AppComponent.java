package com.a081995gmail.ivany4.android.classwork2.injection;

import com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user.UserViewModel;
import com.a081995gmail.ivany4.android.classwork2.pressentation.screens.usermvp.SingInUserPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(UserViewModel userViewModel);
    void inject(SingInUserPresenter userPresenter);
}
