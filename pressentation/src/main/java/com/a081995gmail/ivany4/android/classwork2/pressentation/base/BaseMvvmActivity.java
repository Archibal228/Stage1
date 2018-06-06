package com.a081995gmail.ivany4.android.classwork2.pressentation.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.a081995gmail.ivany4.android.BR;
import com.a081995gmail.ivany4.android.classwork2.pressentation.base.BaseViewModel;
import com.a081995gmail.ivany4.android.classwork2.pressentation.screens.user.UserViewModel;

public abstract class BaseMvvmActivity<Binding extends ViewDataBinding,ViewModel extends BaseViewModel,R extends Router>
        extends AppCompatActivity {


    protected Binding binding;
    protected ViewModel viewModel;
    @Nullable
    protected R router;

    public abstract int provideLayoutId();
    public abstract R provideRouter();

    public abstract ViewModel provideViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, provideLayoutId());
        viewModel = provideViewModel();
        binding.setVariable(BR.viewModel, viewModel);
        router = provideRouter();
        viewModel.attachRouter(router);

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        router = null;
        viewModel.detachRouter();
    }
}