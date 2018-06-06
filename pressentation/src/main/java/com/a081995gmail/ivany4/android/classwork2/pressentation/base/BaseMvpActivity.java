package com.a081995gmail.ivany4.android.classwork2.pressentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a081995gmail.ivany4.android.BR;

public abstract class BaseMvpActivity<Presenter extends BasePresenter,R extends Router>
        extends AppCompatActivity implements BaseView {


    protected Presenter presenter;
    @Nullable
    protected R router;

    public abstract int provideLayoutId();
    public abstract R provideRouter();

    public abstract Presenter providePresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter =  providePresenter();
        setContentView(provideLayoutId());
        router = provideRouter();
        presenter.attach(router,this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        router = null;
        presenter.detach();
        presenter.onDestroy();
    }
}