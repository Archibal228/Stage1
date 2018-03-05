package com.a081995gmail.ivany4.android.classwork2.classwork7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a081995gmail.ivany4.android.R;

/**
 * Created by Archibal on 26.02.2018.
 */

public class OneFragment extends Fragment {
    final static String Key_Value = "Key_Value";
 //   private Disposable disposable;
    //private Observable observable

    public static OneFragment getInstance(FragmentManager fragmentManager, int value) {
        TwoFragment fragment = (TwoFragment) fragmentManager.findFragmentByTag(TwoFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = new TwoFragment();
        }

        Bundle bundle = new Bundle();
        bundle.putInt(Key_Value, value);
        fragment.setArguments(bundle);

        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int value = bundle.getInt(Key_Value);

            //инициализация UI
        }
      //  view.setOnClickListener(new View.OnClickListener());
    }
//    public  subscribe(){
//
//    }

   // @Override
//    public void onResume() {
//        super.onResume();
// disposable =   publishcontract.getpublishSubject()
//            .subscribe(new Consume<Integer>(){
    public void accept (Integer integer){
        //textView.setText(String.valueof(integer));
    }
//    }

    @Override
    public void onPause() {
        super.onPause();
//        if(disposable != null){
//            disposable.dispose();
        }

    @Override
    public void onDetach() {
        super.onDetach();
//        publishcontact = null;
    }
}

