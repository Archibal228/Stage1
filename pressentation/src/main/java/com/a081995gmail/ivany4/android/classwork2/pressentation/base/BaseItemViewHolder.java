package com.a081995gmail.ivany4.android.classwork2.pressentation.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Base64InputStream;
import android.view.View;

import com.a081995gmail.ivany4.android.BR;

/**
 * Created by Archibal on 02.04.2018.
 */

public class BaseItemViewHolder<Model, ViewModel extends BaseItemViewModel,
        Binding extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private Binding binding;
    private ViewModel viewModel;
    public BaseItemViewHolder(Binding binding, ViewModel viewModel) {
        super(binding.getRoot());
        this.binding = binding;
        this.viewModel = viewModel;
        this.viewModel.init();
        initViewModel();
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    protected void initViewModel(){
        binding.setVariable(BR.viewModel,viewModel);
    }

    public void bindTo(Model model,int position){
        viewModel.setItem(model,position);
        binding.executePendingBindings();
    }

    public void release(){
        this.viewModel.release();
    }
}
